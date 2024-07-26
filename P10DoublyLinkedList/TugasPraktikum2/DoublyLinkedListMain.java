package TugasPraktikum2;

import java.util.Scanner;

public class DoublyLinkedListMain {

    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("+++++++++++++++++++++++++");
        System.out.println("  Data Film Layar Lebar  ");
        System.out.println("+++++++++++++++++++++++++");
        System.out.println(
                " 1. Tambah Data Awal\n 2. Tambah Data Akhir\n 3. Tambah Data Index Tertentu\n 4. Hapus Data Pertama\n 5. Hapus Data Terakhir\n 6. Hapus Data Tertentu\n 7. Cetak\n 8. Cari ID Film\n 9. Urut Data Rating Film DESC\n 10. Keluar\n");
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) throws Exception {

        DoublyLinkedList dll = new DoublyLinkedList();

        int pilih;
        do {
            menu();
            pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1:
                    System.out.println("Masukkan Data Film Posisi Awal");
                    System.out.print("ID Film\t\t: ");
                    int id = scanner.nextInt();
                    System.out.print("Judul Film\t: ");
                    String judulFilm = scanner.nextLine();
                    System.out.print("Rating\t\t: ");
                    double rating = scanner.nextDouble();
                    dll.addFirst(id, judulFilm, rating);
                    scanner.nextLine();
                    break;

                case 2:
                    System.out.println("Masukkan Data Film Posisi Akhir");
                    System.out.print("ID Film\t\t: ");
                    int idD = scanner.nextInt();
                    System.out.print("Judul Film\t: ");
                    String judulFilmM = scanner.nextLine();
                    System.out.print("Rating\t\t: ");
                    double ratingG = scanner.nextDouble();
                    dll.addLast(idD, judulFilmM, ratingG);
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("Masukkan Data Film Posisi yang diinginkan");
                    System.out.print("Urutan ke - ");
                    int idx = scanner.nextInt();
                    System.out.print("ID Film\t\t: ");
                    int idDD = scanner.nextInt();
                    System.out.print("Judul Film\t: ");
                    String judulFilmMM = scanner.nextLine();
                    System.out.print("Rating\t\t: ");
                    double ratingGG = scanner.nextDouble();
                    dll.add(idDD, judulFilmMM, ratingGG, idx);
                    scanner.nextLine();
                    break;

                case 4:
                    dll.removeFirst();
                    dll.print();
                    break;

                case 5:
                    dll.removeLast();
                    dll.print();
                    break;

                case 6:
                    System.out.println("hapus Data Film Posisi yang diinginkan");
                    System.out.print("Urutan ke - ");
                    int index = scanner.nextInt();
                    dll.remove(index);
                    dll.print();
                    break;

                case 7:
                    dll.print();
                    break;

                case 8:
                    System.out.println("Cari ID Film Yang ingin dicari");
                    System.out.print("Masukkan ID\t: ");
                    int cari = scanner.nextInt();
                    int idF = dll.findSeqSearch(cari);
                    dll.tampilPosisi(cari, idF);
                    break;

                case 9:
                    System.out.println("Data Akan diurut secara DESC");
                    dll.sort();
                    break;

                case 10:
                    System.exit(0);
                    break;
            }
        } while (pilih >= 1 && pilih <= 10);
    }
}

