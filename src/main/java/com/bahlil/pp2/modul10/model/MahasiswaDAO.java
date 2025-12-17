package com.bahlil.pp2.modul10.model;

import com.bahlil.pp2.modul10.KoneksiDB; // Import koneksi yang sudah kamu buat
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDAO {
    
    // READ
    public List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> listMhs = new ArrayList<>();
        try {
            Connection conn = KoneksiDB.configDB();
            String sql = "SELECT * FROM mahasiswa";
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {
                listMhs.add(new Mahasiswa(
                    res.getInt("id"),
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("jurusan")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMhs;
    }

    // CREATE
    public void addMahasiswa(Mahasiswa mhs) {
        try {
            String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?, ?, ?)";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, mhs.getNama());
            pst.setString(2, mhs.getNim());
            pst.setString(3, mhs.getJurusan());
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateMahasiswa(Mahasiswa mhs) {
        try {
            String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, mhs.getNama());
            pst.setString(2, mhs.getJurusan());
            pst.setString(3, mhs.getNim());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteMahasiswa(String nim) {
        try {
            String sql = "DELETE FROM mahasiswa WHERE nim = ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nim);
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}