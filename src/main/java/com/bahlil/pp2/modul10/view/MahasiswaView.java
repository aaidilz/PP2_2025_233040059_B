package com.bahlil.pp2.modul10.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MahasiswaView extends JFrame {
    private JTextField txtNama, txtNIM, txtJurusan;
    private JButton btnSimpan, btnEdit, btnHapus, btnClear;
    private JTable tableMahasiswa;
    private DefaultTableModel model;

    public MahasiswaView() {
        setTitle("MVC Mahasiswa App");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Form
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);
        
        panelForm.add(new JLabel("NIM:"));
        txtNIM = new JTextField();
        panelForm.add(txtNIM);
        
        panelForm.add(new JLabel("Jurusan:"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);

        // Panel Tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");
        
        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

        // Gabung Panel
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);
        add(panelAtas, BorderLayout.NORTH);

        // Tabel
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Jurusan");
        
        tableMahasiswa = new JTable(model);
        add(new JScrollPane(tableMahasiswa), BorderLayout.CENTER);
    }

    // Getter untuk komponen biar bisa diakses Controller
    public JTextField getTxtNama() { return txtNama; }
    public JTextField getTxtNIM() { return txtNIM; }
    public JTextField getTxtJurusan() { return txtJurusan; }
    public JButton getBtnSimpan() { return btnSimpan; }
    public JButton getBtnEdit() { return btnEdit; }
    public JButton getBtnHapus() { return btnHapus; }
    public JButton getBtnClear() { return btnClear; }
    public JTable getTableMahasiswa() { return tableMahasiswa; }
    public DefaultTableModel getModel() { return model; }
}