package com.bahlil.pp2.modul8.controller;

import com.bahlil.pp2.modul8.model.PersegiPanjangModel;
import com.bahlil.pp2.modul8.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {
    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        // Menghubungkan View dengan Listener di Controller [cite: 84]
        this.view.addHitungLuasListener(new HitungLuasListener());
        this.view.addHitungKelilingListener(new HitungKelilingListener()); // Latihan 2
        this.view.addResetListener(new ResetListener()); // Latihan 3
    }

    // Inner Class untuk Hitung Luas (Latihan 1)
    class HitungLuasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();
                
                model.setPanjang(p);
                model.setLebar(l);
                model.hitungLuas();
                
                view.setHasilLuas(model.getLuas());
            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }

    // Inner Class untuk Hitung Keliling (Latihan 2) 
    class HitungKelilingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();
                
                model.setPanjang(p);
                model.setLebar(l);
                model.hitungKeliling(); // Panggil logika keliling
                
                view.setHasilKeliling(model.getKeliling());
            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }

    // Inner Class untuk Reset (Latihan 3) 
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Kosongkan view
            view.clearInput();
            // Opsional: Reset data di model juga kalau perlu
            model.setPanjang(0);
            model.setLebar(0);
        }
    }
}
