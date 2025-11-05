package com.bahlil.pp2.modul6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class tugas2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Konversi Suhu: Celcius -> Fahrenheit");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(360, 150);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

		JLabel labelC = new JLabel("Celcius:");
		JTextField tfC = new JTextField();
		JButton btnConvert = new JButton("Konversi");
		JLabel labelF = new JLabel("Fahrenheit:");
		JLabel labelResult = new JLabel("");

		panel.add(labelC);
		panel.add(tfC);
		panel.add(btnConvert);
		panel.add(new JLabel());
		panel.add(labelF);
		panel.add(labelResult);

		btnConvert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = tfC.getText().trim();
				if (text.isEmpty()) {
					labelResult.setText("Masukkan angka");
					return;
				}
				try {
					double c = Double.parseDouble(text);
					double f = (c * 9.0 / 5.0) + 32.0;
					labelResult.setText(String.format("%.2f", f));
				} catch (NumberFormatException ex) {
					labelResult.setText("bukan angka");
				}
			}
		});

		tfC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnConvert.doClick();
			}
		});

		frame.add(panel);
		frame.setVisible(true);
	}

}
