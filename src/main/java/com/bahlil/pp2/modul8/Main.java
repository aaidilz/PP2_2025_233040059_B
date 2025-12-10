package com.bahlil.pp2.modul8;

import com.bahlil.pp2.modul8.controller.PersegiPanjangController;
import com.bahlil.pp2.modul8.model.PersegiPanjangModel;
import com.bahlil.pp2.modul8.view.PersegiPanjangView;

public class Main {
    public static void main(String[] args) {
        PersegiPanjangModel model = new PersegiPanjangModel();

        PersegiPanjangView view = new PersegiPanjangView();

        new PersegiPanjangController(model, view);

        view.setVisible(true);
    }
}