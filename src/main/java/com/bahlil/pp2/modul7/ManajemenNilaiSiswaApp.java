package com.bahlil.pp2.modul7;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class ManajemenNilaiSiswaApp extends JFrame {

    private JTextField inputNama;
    private JTextField inputNilai;
    private JComboBox<String> inputMatkul;

    private JTable tableData;
    private DefaultTableModel tableModel;

    private JTabbedPane tabPane;

    public ManajemenNilaiSiswaApp() {
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

        // Grade versi modul (if-else)
        String grade = "";
        if (nilai >= 85) grade = "A";
        else if (nilai >= 75) grade = "B";
        else if (nilai >= 65) grade = "C";
        else if (nilai >= 55) grade = "D";
        else grade = "E";

        tableModel.addRow(new Object[]{
                nama, nilai, matkul, grade
        });

        JOptionPane.showMessageDialog(this,
                "Data berhasil disimpan!",
                "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManajemenNilaiSiswaApp().setVisible(true);
        });
    }
}