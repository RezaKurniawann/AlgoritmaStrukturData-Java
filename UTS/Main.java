import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner RezaKurniawan = new Scanner (System.in);
        Queue que = new Queue(10);
        Pesanan[] pesananArray = new Pesanan[10];
        System.out.println("=============================");
        System.out.println("   Ulangan Tengah Semester");
        System.out.println("=============================");
        System.out.println("Dibuat oleh : Reza Kurniawan ");
        System.out.println("NIM         : 2241760059");
        System.out.println("Absen       : 21");
        System.out.println("=============================");
        int count = 0;
        int pilihan;
        do {
            System.out.println("");
            que.menu();
            System.out.print("\nPilih (1-5) : ");
            pilihan = RezaKurniawan.nextInt();
            RezaKurniawan.nextLine();
            switch (pilihan) {
                case 1:
                System.out.println("---------------------------");
                System.out.println("Masukkan Data Pembeli");
                System.out.println("---------------------------");
                System.out.print("Nomor Antrian : ");
                int antrian = RezaKurniawan.nextInt();
                RezaKurniawan.nextLine();
                System.out.print("Nama Pembeli : ");
                String namaP = RezaKurniawan.nextLine();
                System.out.print("Nomor Hp : ");
                String nohp = RezaKurniawan.nextLine();
                Pembeli pembeli = new Pembeli(antrian, namaP, nohp); 
                que.enqueue(pembeli);
                System.out.println("---------------------------");
                System.out.println(namaP + " Memasuki antrian! ");
                System.out.println("---------------------------");
                break;
                case 2:
                System.out.println("------------------------------------");
                System.out.println("|           Daftar Antrian         |");
                System.out.println("------------------------------------");
                System.out.println("|No     |Nama           |No HP     |");
                System.out.println("------------------------------------");
                que.print();  
                break;
                case 3:
                System.out.println("---------------------------");
                System.out.println("Transaksi Input Pesanan");
                System.out.println("---------------------------");
                System.out.print("Nomor Pesanan : ");
                int noPesanan = RezaKurniawan.nextInt();
                RezaKurniawan.nextLine();
                System.out.print("Pesanan : ");
                String Pesanan = RezaKurniawan.nextLine();
                System.out.print("Harga : ");
                int harga = RezaKurniawan.nextInt();
                Pesanan pesanan = new Pesanan(noPesanan, Pesanan, harga);
                pesananArray[count] = pesanan;
                count++;
                que.Dequeue();
                break;
                case 4:
                //Sorting By Nama (ASCENDING)
                for (int i = 0; i < count - 1; i++) {
                    for (int j = 0; j < count - 1 - i; j++) {
                        if (pesananArray[j] != null && pesananArray[j + 1] != null &&
                            pesananArray[j].namaPesanan != null && pesananArray[j + 1].namaPesanan != null) {
                            if (pesananArray[j].namaPesanan.compareTo(pesananArray[j + 1].namaPesanan) > 0) {
                                // Tukar elemen jika namaPesanan[j] > namaPesanan[j+1]
                                Pesanan temp = pesananArray[j];
                                pesananArray[j] = pesananArray[j + 1];
                                pesananArray[j + 1] = temp;
                            }
                        }
                    }
                }
                System.out.println("------------------------------------");
                System.out.println("|           Daftar Pesanan         |");
                System.out.println("------------------------------------");
                System.out.println("|No     |Nama Pesanan   |Harga     |");
                System.out.println("------------------------------------");
                for (int i = 0; i < count; i++) {
                    System.out.println("|" + String.format("%-7s", pesananArray[i].kodePesanan) + "|" + String.format("%-15s", pesananArray[i].namaPesanan) + "|" + String.format("%-10s", pesananArray[i].harga) + "|");
                }
                System.out.println("------------------------------------");
                break;
                case 5:
                
                int total = 0;
                for (int i = 0; i < count; i++) {
                    total += pesananArray[i].harga; 
                }
                System.out.println("---------------------------");
                System.out.println("Total Pendapatan : " + total);
                System.out.println("---------------------------");
                break;
                case 6:
                System.out.println("\nTerima Kasih!\n");
                break;
                default:
                System.out.println("\nAngka yang Anda Masukkan Salah!\n");
                break;
            }
        } while (pilihan != 6);
    }
}



