package com.bahlil.pp2.modul6;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class latihan1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh FlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();

        panel.add(new javax.swing.JButton("Tombol 1"));
        panel.add(new javax.swing.JButton("Tombol 2"));
        panel.add(new javax.swing.JButton("Tombol 3"));
        panel.add(new javax.swing.JButton("Tombol Empat sangat Panjang"));

        frame.add(panel);
        frame.setVisible(true);
    }
}
