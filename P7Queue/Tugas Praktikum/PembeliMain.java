import java.util.Scanner;

public class PembeliMain {
    public static void menu() {
        System.out.println("Pilih menu: ");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Keluar Antrian");
        System.out.println("3. Lihat Data Pembeli");
        System.out.println("4. Cari Urutan Antrian");
        System.out.println("5. Lihat Antrian Pertama");
        System.out.println("6. Lihat Antrian Terakhir");
        System.out.println("7. Exit");
        System.out.println("-------------------------");
    }

    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan kapasitas Antrian: ");
        int jumlah = sc.nextInt();
        Queue antri = new Queue(jumlah);
        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch (pilih) {
                case 1:                                       
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Nomor HP: ");
                    int nohp = sc.nextInt();
                    Pembeli pbl = new Pembeli(nama, nohp);                    
                    sc.nextLine();
                    antri.enqueue(pbl);
                    break;
                case 2:
                    Pembeli data = antri.dequeue();
                    if (!"".equals(data.nama) && !"".equals(data.noHP)) {
                        System.out.println("Antrian yang keluar: " + data.nama + " " + data.noHP);
                        break;
                    }
                case 3:
                    antri.print();
                    break;
                case 4:
                    System.out.print("Masukkan nama pembeli: ");
                    String namaCari = sc.nextLine();
                    int urutan = antri.cariUrutanAntrian(namaCari);
                    if (urutan != -1) {
                        System.out.println("Urutan antrian untuk " + namaCari + " adalah: " + urutan);
                    } else {
                        System.out.println("Nama " + namaCari + " tidak ditemukan dalam antrian.");
                    }
                    break;
                case 5:
                    antri.peek();
                case 6:
                    antri.peekRear();
                    break;
                case 7:
                    System.out.println("Terima Kasih");
                    break;
            }
        } while (pilih != 7);
    }
}

