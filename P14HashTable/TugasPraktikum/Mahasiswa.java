package TugasPraktikum;

import java.util.ArrayList;

public class Mahasiswa {
    private String nim;
    private String namaLengkap;
    private String jurusan;
    private String programStudi;

    public Mahasiswa(String nim, String namaLengkap, String jurusan, String programStudi) {
        this.nim = nim;
        this.namaLengkap = namaLengkap;
        this.jurusan = jurusan;
        this.programStudi = programStudi;
    }

    public String getNim() {
        return nim;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getProgramStudi() {
        return programStudi;
    }
}

class HashTable {
    private static final int SIZE = 10;
    private ArrayList<Mahasiswa>[] dataMap;

    public HashTable() {
        this.dataMap = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            dataMap[i] = new ArrayList<>();
        }
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        int index = hash(mahasiswa.getNim());
        dataMap[index].add(mahasiswa);
    }

    public Mahasiswa findMahasiswa(String nim) {
        int index = hash(nim);
        for (Mahasiswa mahasiswa : dataMap[index]) {
            if (mahasiswa.getNim().equals(nim)) {
                return mahasiswa;
            }
        }
        return null; // Mahasiswa not found
    }

    public void removeMahasiswa(String nim) {
        int index = hash(nim);
        dataMap[index].removeIf(mahasiswa -> mahasiswa.getNim().equals(nim));
    }

    public ArrayList<String> getAllNIMs() {
        ArrayList<String> allNIMs = new ArrayList<>();
        for (ArrayList<Mahasiswa> mahasiswas : dataMap) {
            for (Mahasiswa mahasiswa : mahasiswas) {
                allNIMs.add(mahasiswa.getNim());
            }
        }
        return allNIMs;
    }

    private int hash(String nim) {
        int hash = 0;
        for (int i = 0; i < nim.length(); i++) {
            hash = (hash + nim.charAt(i) * i) % SIZE;
        }
        return hash;
    }
}

class Main {
    public static void main(String[] args) {
        HashTable mahasiswaTable = new HashTable();

        // Menambahkan data mahasiswa
        Mahasiswa mahasiswa1 = new Mahasiswa("190001", "John Doe", "Teknik Informatika", "S1");
        Mahasiswa mahasiswa2 = new Mahasiswa("190002", "Jane Doe", "Sistem Informasi", "S1");

        mahasiswaTable.addMahasiswa(mahasiswa1);
        mahasiswaTable.addMahasiswa(mahasiswa2);

        // Menampilkan seluruh NIM mahasiswa
        System.out.println("NIM Mahasiswa yang Tersimpan:");
        ArrayList<String> allNIMs = mahasiswaTable.getAllNIMs();
        for (String nim : allNIMs) {
            System.out.println(nim);
        }

        // Mencari mahasiswa berdasarkan NIM
        String targetNIM = "190001";
        Mahasiswa foundMahasiswa = mahasiswaTable.findMahasiswa(targetNIM);
        if (foundMahasiswa != null) {
            System.out.println("\nMahasiswa dengan NIM " + targetNIM + " ditemukan:");
            System.out.println("Nama: " + foundMahasiswa.getNamaLengkap());
            System.out.println("Jurusan: " + foundMahasiswa.getJurusan());
            System.out.println("Program Studi: " + foundMahasiswa.getProgramStudi());
        } else {
            System.out.println("\nMahasiswa dengan NIM " + targetNIM + " tidak ditemukan.");
        }

        // Menghapus mahasiswa berdasarkan NIM
        String nimToDelete = "190002";
        System.out.println("\nMenghapus mahasiswa dengan NIM " + nimToDelete);
        mahasiswaTable.removeMahasiswa(nimToDelete);

        // Menampilkan seluruh NIM mahasiswa setelah penghapusan
        System.out.println("\nNIM Mahasiswa setelah Penghapusan:");
        allNIMs = mahasiswaTable.getAllNIMs();
        for (String nim : allNIMs) {
            System.out.println(nim);
        }
    }
}
