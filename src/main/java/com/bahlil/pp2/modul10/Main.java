package com.bahlil.pp2.modul10;

import com.bahlil.pp2.modul10.controller.MahasiswaController;
import com.bahlil.pp2.modul10.model.MahasiswaDAO;
import com.bahlil.pp2.modul10.view.MahasiswaView;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Siapkan Model
            MahasiswaDAO dao = new MahasiswaDAO();
            
            // 2. Siapkan View
            MahasiswaView view = new MahasiswaView();
            
            // 3. Gabungkan dalam Controller
            new MahasiswaController(view, dao);
            
            // 4. Tampilkan View
            view.setVisible(true);
        });
    }
}