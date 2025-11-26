package com.bahlil.pp2.modul7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class tugas3 extends JFrame {

    private JTextField inputNama;
    private JTextField inputNilai;
    private JComboBox<String> inputMatkul;

    private JTable tableData;
    private DefaultTableModel tableModel;

    private JTabbedPane tabPane;

    public tugas3() {
        setTitle("Manajemen Nilai Siswa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabPane = new JTabbedPane();

        tabPane.addTab("Input Data", createInputPanel());
        tabPane.addTab("Daftar Nilai", createTablePanel());

        add(tabPane);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelNama = new JLabel("Nama Siswa:");
        JLabel labelNilai = new JLabel("Nilai:");
        JLabel labelMatkul = new JLabel("Mata Kuliah:");

        inputNama = new JTextField();
        inputNilai = new JTextField();

        inputMatkul = new JComboBox<>(new String[]{
                "Algoritma",
                "Basis Data",
                "Pemrograman II",
                "Matematika"
        });

        JButton btnSimpan = new JButton("Simpan Data");
        btnSimpan.addActionListener(e -> prosesSimpan());

        panel.add(labelNama);
        panel.add(inputNama);

        panel.add(labelNilai);
        panel.add(inputNilai);

        panel.add(labelMatkul);
        panel.add(inputMatkul);

        panel.add(btnSimpan);

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(
            new Object[]{"Nama", "Nilai", "Mata Kuliah", "Grade"},
            0
        );

        tableData = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableData);

        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnHapus = new JButton("Hapus Data");
        
        btnHapus.addActionListener(e -> {
            int selectedRow = tableData.getSelectedRow();
            
            if (selectedRow > -1) {
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, 
                        "Data berhasil dihapus!", 
                        "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                        "Pilih baris data yang ingin dihapus terlebih dahulu!", 
                        "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });

        buttonPanel.add(btnHapus);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void prosesSimpan() {
        String nama = inputNama.getText().trim();
        String strNilai = inputNilai.getText().trim();
        String matkul = (String) inputMatkul.getSelectedItem();

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nama tidak boleh kosong!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nama.length() < 3) {
            JOptionPane.showMessageDialog(this,
                    "Nama harus terdiri dari minimal 3 karakter!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int nilai;

        try {
            nilai = Integer.parseInt(strNilai);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Nilai harus berupa angka!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nilai < 0 || nilai > 100) {
            JOptionPane.showMessageDialog(this,
                    "Nilai harus antara 0 - 100!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String grade;
        switch (nilai / 10) {
            case 10:
            case 9:  grade = "A"; break;
            case 8:  grade = "B"; break;
            case 7:  grade = "C"; break;
            case 6:  grade = "D"; break;
            default: grade = "E"; break;
        }

        tableModel.addRow(new Object[]{
                nama, nilai, matkul, grade
        });

        JOptionPane.showMessageDialog(this,
                "Data berhasil disimpan!",
                "Sukses", JOptionPane.INFORMATION_MESSAGE);
        
        inputNama.setText("");
        inputNilai.setText("");
        inputNama.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new tugas3().setVisible(true);
        });
    }
}