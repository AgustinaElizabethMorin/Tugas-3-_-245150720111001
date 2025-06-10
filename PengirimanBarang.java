
import java.util.Scanner;

public class PengirimanBarang {
    // Atribut kelas
    private String namaPengirim;
    private String alamatTujuan;
    private double berat;
    private double biayaDasar;
    
    // Constructor overloading
    
    // 1. Default Constructor
    public PengirimanBarang() {
        this.namaPengirim = "";
        this.alamatTujuan = "";
        this.berat = 0.0;
        this.biayaDasar = 0.0;
        System.out.println("Default constructor dipanggil - Data diinisialisasi dengan nilai default");
    }
    
    // Method untuk menampilkan informasi pengiriman
    public void displayInfoPengiriman() {
        System.out.println("=== INFORMASI PENGIRIMAN ===");
        System.out.println("Nama Pengirim: " + namaPengirim);
        System.out.println("Alamat Tujuan: " + alamatTujuan);
        System.out.printf("Berat Barang: %.2f kg\n", berat);
        System.out.printf("Biaya Dasar: Rp %.2f\n", biayaDasar);
        System.out.println("============================\n");
    }
    
    // 2. Overloaded Constructor dengan semua parameter
    public PengirimanBarang(String namaPengirim, String alamatTujuan, double berat, double biayaDasar) {
        this.namaPengirim = namaPengirim;
        this.alamatTujuan = alamatTujuan;
        this.berat = berat;
        this.biayaDasar = biayaDasar;
        System.out.println("Parameterized constructor dipanggil - Data diinisialisasi dengan parameter");
    }
    
    // Method overloading - hitungOngkir()
    
    // 1. hitungOngkir dengan diskon persentase
    public double hitungOngkir(double diskonPersen) {
        double diskonAmount = biayaDasar * (diskonPersen / 100);
        double biayaSetelahDiskon = biayaDasar - diskonAmount;
        
        System.out.printf("Perhitungan dengan diskon %.1f%%:\n", diskonPersen);
        System.out.printf("Biaya dasar: Rp %.2f\n", biayaDasar);
        System.out.printf("Diskon: Rp %.2f\n", diskonAmount);
        System.out.printf("Total biaya: Rp %.2f\n\n", biayaSetelahDiskon);
        
        return biayaSetelahDiskon;
    }
    
    // 2. hitungOngkir dengan diskon persentase dan biaya tambahan
    public double hitungOngkir(double diskonPersen, double biayaTambahan) {
        double diskonAmount = biayaDasar * (diskonPersen / 100);
        double biayaSetelahDiskon = biayaDasar - diskonAmount;
        double totalBiaya = biayaSetelahDiskon + biayaTambahan;
        
        System.out.printf("Perhitungan dengan diskon %.1f%% dan biaya tambahan:\n", diskonPersen);
        System.out.printf("Biaya dasar: Rp %.2f\n", biayaDasar);
        System.out.printf("Diskon: Rp %.2f\n", diskonAmount);
        System.out.printf("Biaya setelah diskon: Rp %.2f\n", biayaSetelahDiskon);
        System.out.printf("Biaya tambahan: Rp %.2f\n", biayaTambahan);
        System.out.printf("Total biaya: Rp %.2f\n\n", totalBiaya);
        
        return totalBiaya;
    }
    
    // 3. hitungOngkir berdasarkan jarak
    public double hitungOngkir(int jarak) {
        double totalBiaya;
        
        System.out.printf("Perhitungan berdasarkan jarak %d km:\n", jarak);
        System.out.printf("Biaya dasar: Rp %.2f\n", biayaDasar);
        
        if (jarak > 50) {
            // Surcharge 10% untuk jarak > 50 km
            double surcharge = biayaDasar * 0.10;
            totalBiaya = biayaDasar + surcharge;
            System.out.printf("Jarak > 50 km - Surcharge 10%%: Rp %.2f\n", surcharge);
        } else {
            // Diskon 5% untuk jarak <= 50 km
            double diskon = biayaDasar * 0.05;
            totalBiaya = biayaDasar - diskon;
            System.out.printf("Jarak ≤ 50 km - Diskon 5%%: Rp %.2f\n", diskon);
        }
        
        System.out.printf("Total biaya: Rp %.2f\n\n", totalBiaya);
        return totalBiaya;
    }
    
    // Method untuk menampilkan informasi statis perusahaan
    public static void displayInfoLogistik() {
        System.out.println("=== INFORMASI PERUSAHAAN LOGISTIK ===");
        System.out.println("Nama Perusahaan: PT. Kirim Cepat Indonesia");
        System.out.println("Alamat: Jl. Logistik No. 123, Jakarta");
        System.out.println("Telepon: (021) 555-0123");
        System.out.println("Email: info@kirimcepat.co.id");
        System.out.println("Layanan: Pengiriman domestik dan internasional");
        System.out.println("Jam Operasional: Senin-Sabtu 08:00-17:00 WIB");
        System.out.println("=====================================\n");
    }
    
    // Getter dan Setter methods (Encapsulation)
    public String getNamaPengirim() {
        return namaPengirim;
    }
    
    public void setNamaPengirim(String namaPengirim) {
        this.namaPengirim = namaPengirim;
    }
    
    public String getAlamatTujuan() {
        return alamatTujuan;
    }
    
    public void setAlamatTujuan(String alamatTujuan) {
        this.alamatTujuan = alamatTujuan;
    }
    
    public double getBerat() {
        return berat;
    }
    
    public void setBerat(double berat) {
        this.berat = berat;
    }
    
    public double getBiayaDasar() {
        return biayaDasar;
    }
    
    public void setBiayaDasar(double biayaDasar) {
        this.biayaDasar = biayaDasar;
    }
    
    // Method untuk input data pengiriman dari user
    public void inputDataPengiriman() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== INPUT DATA PENGIRIMAN ===");
        System.out.print("Masukkan nama pengirim: ");
        this.namaPengirim = scanner.nextLine();
        
        System.out.print("Masukkan alamat tujuan: ");
        this.alamatTujuan = scanner.nextLine();
        
        System.out.print("Masukkan berat barang (kg): ");
        this.berat = scanner.nextDouble();
        
        System.out.print("Masukkan biaya dasar (Rp): ");
        this.biayaDasar = scanner.nextDouble();
        
        System.out.println("Data pengiriman berhasil diinput!\n");
    }
    
    // Method interactive untuk perhitungan ongkir dengan input user
    public void hitungOngkirInteraktif() {
        Scanner scanner = new Scanner(System.in);
        boolean lanjut = true;
        
        while (lanjut) {
            System.out.println("=== PILIH METODE PERHITUNGAN ONGKIR ===");
            System.out.println("1. Perhitungan dengan Diskon Persentase");
            System.out.println("2. Perhitungan dengan Diskon + Biaya Tambahan");
            System.out.println("3. Perhitungan Berdasarkan Jarak");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Pilihan Anda (1-4): ");
            
            int pilihan = scanner.nextInt();
            
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan persentase diskon (%): ");
                    double diskon = scanner.nextDouble();
                    hitungOngkir(diskon);
                    break;
                    
                case 2:
                    System.out.print("Masukkan persentase diskon (%): ");
                    double diskonPersen = scanner.nextDouble();
                    System.out.print("Masukkan biaya tambahan (Rp): ");
                    double biayaTambahan = scanner.nextDouble();
                    hitungOngkir(diskonPersen, biayaTambahan);
                    break;
                    
                case 3:
                    System.out.print("Masukkan jarak pengiriman (km): ");
                    int jarak = scanner.nextInt();
                    hitungOngkir(jarak);
                    break;
                    
                case 4:
                    lanjut = false;
                    System.out.println("Kembali ke menu utama...\n");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-4.\n");
                    break;
            }
            
            if (lanjut && pilihan >= 1 && pilihan <= 3) {
                System.out.print("Apakah ingin melakukan perhitungan lagi? (y/n): ");
                char jawab = scanner.next().charAt(0);
                if (jawab == 'n' || jawab == 'N') {
                    lanjut = false;
                }
                System.out.println();
            }
        }
    }
}
