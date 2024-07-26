import java.util.Scanner;

public class MahasiswaMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // pastikan import package scanner
        Scanner sl = new Scanner(System.in);
        
        PencarianMhs data = new PencarianMhs();
        int jumMhs = 5;
        
        System.out.println("-----------------------------------");
        System.out.println("Masukkan data mahasiswa secara urut dari Nim Terkecil");
        for(int i=0; i < jumMhs; i++) {
            System.out.println("----------------");
            System.out.print("Nim\t: ");
            int nim = s.nextInt();
            System.out.print("Nama\t: ");
            String nama = sl.nextLine();
            System.out.print("Umur\t : ");
            int umur = s.nextInt();
            System.out.print("IPK\t : ");
            double ipk = s.nextDouble();
            
            Mahasiswa m = new Mahasiswa(nim, nama, umur, ipk);
            data.tambah(m);
        }
        
        System.out.println("-----------------------------------");
        System.out.println("Data keseluruhan Mahasiswa");
        data.tampil();
        
        // Proses pencarian data
        System.out.println("___________________________________");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan Nim Mahasiswa yang dicari: ");
        System.out.print("NIM: ");
        int cari = s.nextInt();
        System.out.println("menggunakan sequential Search");
        int posisi = data.findSeqSearch(cari);
        
        // Tampilkan posisi data
        data.tampilPosisi(cari, posisi);
        
        // Tampilkan data hasil pencarian
        data.tampilData(cari, posisi);
        System.out.println("====================================");
        System.out.println("menggunakan binary Search");
        posisi = data.findBinarySearch(cari, 0, jumMhs -1);

        // Tampilkan posisi data
        data.tampilPosisi(cari, posisi);

        // Tampilkan data hasil pencarian
        data.tampilData(cari, posisi);
        
    }
}