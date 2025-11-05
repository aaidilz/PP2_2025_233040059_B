package com.bahlil.pp2.modul6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class latihan5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh MouseListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(200, 200));

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                panel.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                panel.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("Panel diklik di posisi: " + e.getX() + ", " + e.getY());
            }
        };

        panel.addMouseListener(mouseAdapter);
        frame.add(panel);
        frame.setVisible(true);
    }
}
