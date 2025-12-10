package com.bahlil.pp2.modul9;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AplikasiFileIO extends JFrame {

    // Komponen UI
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText, btnAppendText;
    private JButton btnSaveBinary, btnLoadBinary;
    private JButton btnSaveObj, btnLoadObj;
    private JFileChooser fileChooser;

    public AplikasiFileIO() {
        super("File IO & Exception Handling)");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi Komponen
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();

        // Panel Tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 4, 5, 5));

        // Latihan 1 & 4 (Text)
        btnOpenText = new JButton("Buka Text");
        btnSaveText = new JButton("Simpan (Overwrite)");
        btnAppendText = new JButton("Simpan (Append)");

        // Latihan 1 (Binary Primitive)
        btnSaveBinary = new JButton("Simpan Font (Bin)");
        btnLoadBinary = new JButton("Muat Font (Bin)");
        
        // Latihan 3 (Object Serialization)
        btnSaveObj = new JButton("Simpan Objek");
        btnLoadObj = new JButton("Muat Objek");

        // Menambahkan tombol ke panel
        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnAppendText);
        buttonPanel.add(new JLabel(""));
        
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);
        buttonPanel.add(btnSaveObj);
        buttonPanel.add(btnLoadObj);

        // Layout Utama
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // --- Event Handling ---

        // Latihan 1: Buka File
        btnOpenText.addActionListener(e -> bukaFileTeks());

        // Latihan 1: Simpan File (Overwrite)
        btnSaveText.addActionListener(e -> simpanFileTeks(false));

        // Latihan 4: Simpan File (Append)
        btnAppendText.addActionListener(e -> simpanFileTeks(true));

        // Latihan 1: Binary (Int)
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
        
        // Latihan 3: Object Serialization
        btnSaveObj.addActionListener(e -> simpanUserConfig());
        btnLoadObj.addActionListener(e -> muatUserConfig());

        //Latihan 2: Auto-Read on Startup 
        muatLastNotes();
    }

    // ================= LATIHAN 2 (Auto Load) =================
    private void muatLastNotes() {
        File file = new File("last_notes.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                textArea.setText(""); // Reset
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                // Tidak perlu popup pesan agar tidak mengganggu saat startup
                System.out.println("Berhasil memuat last_notes.txt");
            } catch (IOException ex) {
                // Silent catch (sesuai instruksi modul: "hanya diam saja")
                System.err.println("Gagal memuat last_notes: " + ex.getMessage());
            }
        }
    }

    // ================= LATIHAN 1 & 4 (Text IO) =================
    private void bukaFileTeks() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            // Konvensional Try-Catch-Finally (sesuai Modul)
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                JOptionPane.showMessageDialog(this, "File berhasil dimuat!");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan: " + ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file: " + ex.getMessage());
            } finally {
                try {
                    if (reader != null) reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Parameter 'append' boolean untuk menangani Latihan 4
    private void simpanFileTeks(boolean append) {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            // Try-with-resources (Modern Way)
            // Latihan 4: Konstruktor FileWriter(file, append)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
                writer.write(textArea.getText());
                // Tambahkan baris baru jika append agar tidak nempel
                if (append) writer.newLine(); 
                
                String mode = append ? "ditambahkan (append)" : "disimpan (overwrite)";
                JOptionPane.showMessageDialog(this, "File berhasil " + mode + "!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + ex.getMessage());
            }
        }
    }

    // =================  LATIHAN 1 (Binary IO - Primitive) =================
    private void simpanConfigBinary() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("config.bin"))) {
            int fontSize = textArea.getFont().getSize();
            dos.writeInt(fontSize);
            JOptionPane.showMessageDialog(this, "Ukuran font (" + fontSize + ") disimpan ke config.bin");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan binary: " + ex.getMessage());
        }
    }

    private void muatConfigBinary() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("config.bin"))) {
            int fontSize = dis.readInt();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
            JOptionPane.showMessageDialog(this, "Font diubah menjadi ukuran: " + fontSize);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal membaca binary: " + ex.getMessage());
        }
    }

    // =================  LATIHAN 3 (Object Serialization) =================
    private void simpanUserConfig() {
        // Ambil data username dari input dialog sederhana
        String username = JOptionPane.showInputDialog(this, "Masukkan Username untuk disimpan:");
        if (username != null && !username.isEmpty()) {
            int fontSize = textArea.getFont().getSize();
            UserConfig config = new UserConfig(username, fontSize);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.cfg"))) {
                oos.writeObject(config); // Simpan Objek Utuh
                JOptionPane.showMessageDialog(this, "Objek UserConfig berhasil disimpan ke user.cfg!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan objek: " + ex.getMessage());
            }
        }
    }

    private void muatUserConfig() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.cfg"))) {
            // Baca Objek dan Casting
            UserConfig config = (UserConfig) ois.readObject();
            
            // Terapkan konfigurasi
            textArea.setFont(new Font("Monospaced", Font.PLAIN, config.getFontSize()));
            
            JOptionPane.showMessageDialog(this, 
                "Config Dimuat:\nUsername: " + config.getUsername() + 
                "\nFont Size: " + config.getFontSize());
                
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat objek: " + ex.getMessage());
        }
    }

    // Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplikasiFileIO().setVisible(true);
        });
    }
}