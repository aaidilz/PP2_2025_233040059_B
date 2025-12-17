package com.bahlil.pp2.modul10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiDB {
    
    private static Connection mysqlconfig;
    
    public static Connection configDB() throws SQLException {
        try {
            // URL Database (Ganti nama database jika berbeda)
            String url = "jdbc:mysql://localhost:3306/kampus_db";
            String user = "root";
            String pass = "rootpassword";
            
            // Buat Koneksi
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
        }
        
        return mysqlconfig;
    }
}