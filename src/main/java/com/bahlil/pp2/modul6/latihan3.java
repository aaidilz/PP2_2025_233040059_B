package com.bahlil.pp2.modul6;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class latihan3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh GridLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        frame.setLayout(new GridLayout(3,2,5,5));

        frame.add(new JLabel("Label 1"));
        frame.add(new JTextField());
        frame.add(new JLabel("Label 2"));
        frame.add(new JPasswordField());
        frame.add(new JButton("Login"));
        frame.add(new JButton("Cancel"));

        frame.setVisible(true);
    }   
}
