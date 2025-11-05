/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bahlil.pp2.modul5;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
/**
 *
 * @author dilz
 */
public class latihan3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Latihan 1");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);


                frame.setLayout(new FlowLayout());
                JLabel label = new JLabel("Hello, ini dari javafx!", JLabel.CENTER);
                JButton button = new JButton("Ini Button");


                button.addActionListener(e -> {
                    label.setText("Button dipijit!");
                });
                frame.add(label);
                frame.add(button);
                frame.setVisible(true);
            }
        });
    }
}
