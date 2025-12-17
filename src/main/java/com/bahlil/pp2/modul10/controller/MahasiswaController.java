package com.bahlil.pp2.modul10.controller;

import com.bahlil.pp2.modul10.model.Mahasiswa;
import com.bahlil.pp2.modul10.model.MahasiswaDAO;
import com.bahlil.pp2.modul10.view.MahasiswaView;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MahasiswaController {
    private MahasiswaView view;
    private MahasiswaDAO dao;

    public MahasiswaController(MahasiswaView view, MahasiswaDAO dao) {
        this.view = view;
        this.dao = dao;

        // Set Listener untuk Tombol
        this.view.getBtnSimpan().addActionListener(e -> simpanData());
        this.view.getBtnEdit().addActionListener(e -> editData());
        this.view.getBtnHapus().addActionListener(e -> hapusData());
        this.view.getBtnClear().addActionListener(e -> clearForm());

        // Set Listener untuk Tabel (Klik baris)
        this.view.getTableMahasiswa().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = view.getTableMahasiswa().getSelectedRow();
                view.getTxtNama().setText(view.getModel().getValueAt(row, 1).toString());
                view.getTxtNIM().setText(view.getModel().getValueAt(row, 2).toString());
                view.getTxtJurusan().setText(view.getModel().getValueAt(row, 3).toString());
            }
        });

        // Load data awal
        loadData();
    }

    private void loadData() {
        view.getModel().setRowCount(0); // Reset tabel
        List<Mahasiswa> data = dao.getAllMahasiswa();
        int no = 1;
        for (Mahasiswa m : data) {
            view.getModel().addRow(new Object[]{
                no++,
                m.getNama(),
                m.getNim(),
                m.getJurusan()
            });
        }
    }

    private void simpanData() {
        if (checkInput()) return;
        Mahasiswa mhs = new Mahasiswa(0, 
            view.getTxtNama().getText(), 
            view.getTxtNIM().getText(), 
            view.getTxtJurusan().getText()
        );
        dao.addMahasiswa(mhs);
        JOptionPane.showMessageDialog(view, "Data Berhasil Disimpan");
        loadData();
        clearForm();
    }

    private void editData() {
        if (checkInput()) return;
        Mahasiswa mhs = new Mahasiswa(0, 
            view.getTxtNama().getText(), 
            view.getTxtNIM().getText(), 
            view.getTxtJurusan().getText()
        );
        dao.updateMahasiswa(mhs);
        JOptionPane.showMessageDialog(view, "Data Berhasil Diubah");
        loadData();
        clearForm();
    }

    private void hapusData() {
        if (view.getTxtNIM().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Pilih data dahulu!");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(view, "Yakin hapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dao.deleteMahasiswa(view.getTxtNIM().getText());
            JOptionPane.showMessageDialog(view, "Data Berhasil Dihapus");
            loadData();
            clearForm();
        }
    }

    private void clearForm() {
        view.getTxtNama().setText("");
        view.getTxtNIM().setText("");
        view.getTxtJurusan().setText("");
    }
    
    private boolean checkInput() {
        if (view.getTxtNama().getText().isEmpty() || view.getTxtNIM().getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Nama dan NIM tidak boleh kosong!");
            return true;
        }
        return false;
    }
}