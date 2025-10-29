/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bahlil.pp2.modul5;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
/**
 *
 * @author dilz
 */
public class latihan4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Latihan 1");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);

                frame.setLayout(new BorderLayout());
                JLabel label = new JLabel("Hello, Swing! (NORTH)", JLabel.CENTER);
                JButton button = new JButton("Ini Button (SOUTH)");
                

                frame.add(label, BorderLayout.NORTH);
                frame.add(button, BorderLayout.SOUTH);
                // Buttons with actions (except SOUTH)
                JButton westBtn = new JButton("WEST");
                westBtn.addActionListener(e -> label.setText("Klik tombol: " + e.getActionCommand()));
                frame.add(westBtn , BorderLayout.WEST);

                JButton eastBtn = new JButton("EAST");
                eastBtn.addActionListener(e -> label.setText("Klik tombol: " + e.getActionCommand()));
                frame.add(eastBtn , BorderLayout.EAST);

                JButton centerBtn = new JButton("CENTER");
                centerBtn.addActionListener(e -> label.setText("Klik tombol: " + e.getActionCommand()));
                frame.add(centerBtn , BorderLayout.CENTER);

                frame.setVisible(true);
            }
        });
    }
}
