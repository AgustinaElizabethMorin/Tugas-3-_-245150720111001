// File: MainPengiriman.java
// Main Class Interactive untuk Sistem Manajemen Pengiriman Barang

import java.util.Scanner;

public class MainPengirim {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEM MANAJEMEN PENGIRIMAN BARANG ===\n");
        
        // Menampilkan informasi perusahaan logistik
        PengirimanBarang.displayInfoLogistik();
        
        boolean programBerjalan = true;
        
        while (programBerjalan) {
            tampilkanMenuUtama();
            System.out.print("Pilihan Anda (1-5): ");
            int pilihan = scanner.nextInt();
            
            switch (pilihan) {
                case 1:
                    demoConstructorOverloading();
                    break;
                case 2:
                    demoMethodOverloading();
                    break;
                case 3:
                    modeInteraktif();
                    break;
                case 4:
                    modeManual();
                    break;
                case 5:
                    programBerjalan = false;
                    System.out.println("Terima kasih telah menggunakan sistem kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-5.\n");
                    break;
            }
        }
        
        scanner.close();
    }
    
    public static void tampilkanMenuUtama() {
        System.out.println("=== MENU UTAMA ===");
        System.out.println("1. Demo Constructor Overloading");
        System.out.println("2. Demo Method Overloading");
        System.out.println("3. Mode Interaktif (Input Sendiri)");
        System.out.println("4. Mode Manual (Input Custom)");
        System.out.println("5. Keluar");
        System.out.println("==================");
    }
    
    public static void demoConstructorOverloading() {
        System.out.println("\n=== DEMO CONSTRUCTOR OVERLOADING ===");
        
        // Demo Default Constructor
        System.out.println("1. Default Constructor:");
        PengirimanBarang pengiriman1 = new PengirimanBarang();
        
        // Set data menggunakan setter
        pengiriman1.setNamaPengirim("Demo User 1");
        pengiriman1.setAlamatTujuan("Jl. Demo No. 1, Jakarta");
        pengiriman1.setBerat(2.0);
        pengiriman1.setBiayaDasar(40000.0);
        
        pengiriman1.displayInfoPengiriman();
        
        // Demo Parameterized Constructor
        System.out.println("2. Parameterized Constructor:");
        PengirimanBarang pengiriman2 = new PengirimanBarang(
            "Demo User 2", 
            "Jl. Demo No. 2, Bandung", 
            3.5, 
            55000.0
        );
        
        pengiriman2.displayInfoPengiriman();
        
        System.out.println("Demo constructor overloading selesai!\n");
        tekanEnterUntukLanjut();
    }
    
    public static void demoMethodOverloading() {
        System.out.println("\n=== DEMO METHOD OVERLOADING ===");
        
        PengirimanBarang demo = new PengirimanBarang(
            "Demo Overloading",
            "Jl. Method No. 123, Surabaya",
            4.0,
            60000.0
        );
        
        demo.displayInfoPengiriman();
        
        System.out.println("Testing 3 Method Overloading:");
        
        // Method 1: Diskon saja
        System.out.println("1. Method hitungOngkir(double diskonPersen):");
        demo.hitungOngkir(15.0);
        
        // Method 2: Diskon + Biaya Tambahan
        System.out.println("2. Method hitungOngkir(double diskonPersen, double biayaTambahan):");
        demo.hitungOngkir(10.0, 8000.0);
        
        // Method 3: Berdasarkan Jarak
        System.out.println("3. Method hitungOngkir(int jarak):");
        demo.hitungOngkir(75);
        demo.hitungOngkir(30);
        
        System.out.println("Demo method overloading selesai!\n");
        tekanEnterUntukLanjut();
    }
    
    public static void modeInteraktif() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== MODE INTERAKTIF ===");
        System.out.println("Silakan input data pengiriman Anda sendiri!");
        
        // Buat objek dengan default constructor
        PengirimanBarang pengirimanUser = new PengirimanBarang();
        
        // Input data dari user
        pengirimanUser.inputDataPengiriman();
        
        // Tampilkan data yang sudah diinput
        pengirimanUser.displayInfoPengiriman();
        
        // Menu perhitungan interaktif
        pengirimanUser.hitungOngkirInteraktif();
        
        System.out.println("Mode interaktif selesai!\n");
        tekanEnterUntukLanjut();
    }
    
    public static void modeManual() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== MODE MANUAL ===");
        System.out.println("Input data pengiriman secara manual:");
        
        System.out.print("Nama pengirim: ");
        scanner.nextLine(); // consume newline
        String nama = scanner.nextLine();
        
        System.out.print("Alamat tujuan: ");
        String alamat = scanner.nextLine();
        
        System.out.print("Berat barang (kg): ");
        double berat = scanner.nextDouble();
        
        System.out.print("Biaya dasar (Rp): ");
        double biayaDasar = scanner.nextDouble();
        
        // Buat objek dengan parameterized constructor
        PengirimanBarang pengirimanManual = new PengirimanBarang(nama, alamat, berat, biayaDasar);
        
        pengirimanManual.displayInfoPengiriman();
        
        boolean lanjutHitung = true;
        while (lanjutHitung) {
            System.out.println("=== PILIH METODE PERHITUNGAN ===");
            System.out.println("1. Diskon Persentase");
            System.out.println("2. Diskon + Biaya Tambahan");
            System.out.println("3. Berdasarkan Jarak");
            System.out.println("4. Selesai");
            System.out.print("Pilihan (1-4): ");
            
            int pilihan = scanner.nextInt();
            
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan diskon (%): ");
                    double diskon = scanner.nextDouble();
                    double hasil1 = pengirimanManual.hitungOngkir(diskon);
                    System.out.printf("Hasil perhitungan: Rp %.2f\n\n", hasil1);
                    break;
                    
                case 2:
                    System.out.print("Masukkan diskon (%): ");
                    double diskonPersen = scanner.nextDouble();
                    System.out.print("Masukkan biaya tambahan (Rp): ");
                    double biayaTambahan = scanner.nextDouble();
                    double hasil2 = pengirimanManual.hitungOngkir(diskonPersen, biayaTambahan);
                    System.out.printf("Hasil perhitungan: Rp %.2f\n\n", hasil2);
                    break;
                    
                case 3:
                    System.out.print("Masukkan jarak (km): ");
                    int jarak = scanner.nextInt();
                    double hasil3 = pengirimanManual.hitungOngkir(jarak);
                    System.out.printf("Hasil perhitungan: Rp %.2f\n\n", hasil3);
                    break;
                    
                case 4:
                    lanjutHitung = false;
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid!\n");
                    break;
            }
        }
        
        System.out.println("Mode manual selesai!\n");
        tekanEnterUntukLanjut();
    }
    
    public static void tekanEnterUntukLanjut() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tekan Enter untuk kembali ke menu utama...");
        scanner.nextLine();
        System.out.println();
    }
}
