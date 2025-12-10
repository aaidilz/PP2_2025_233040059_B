package com.bahlil.pp2.modul8.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersegiPanjangView extends JFrame {
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasilLuas = new JLabel("-");
    private JButton btnHitungLuas = new JButton("Hitung Luas");
    
    private JLabel lblHasilKeliling = new JLabel("-");
    private JButton btnHitungKeliling = new JButton("Hitung Keliling");
    private JButton btnReset = new JButton("Reset / Hapus");
    

    public PersegiPanjangView() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setTitle("MVC Kalkulator");
        
        this.setLayout(new GridLayout(0, 2, 10, 10)); 

        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        
        this.add(btnHitungLuas);
        this.add(lblHasilLuas);
        
        this.add(btnHitungKeliling);
        this.add(lblHasilKeliling);
        
        this.add(btnReset);
        this.add(new JLabel(""));
    }

    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    public void setHasilLuas(double hasil) {
        lblHasilLuas.setText("Luas: " + hasil);
    }
    
    public void setHasilKeliling(double hasil) {
        lblHasilKeliling.setText("Keliling: " + hasil);
    }

    public void clearInput() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasilLuas.setText("-");
        lblHasilKeliling.setText("-");
    }

    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void addHitungLuasListener(ActionListener listener) {
        btnHitungLuas.addActionListener(listener);
    }
    
    public void addHitungKelilingListener(ActionListener listener) {
        btnHitungKeliling.addActionListener(listener);
    }
    
    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
}
