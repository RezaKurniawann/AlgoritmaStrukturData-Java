import java.util.Scanner;
public class MainBarang {
    
    public static void main (String[] args) {
        int pilihan, tempStok, indexBarang, count = 0, countInvoice = 0;
        String tempKode;

        int[] idxNama = new int[100];
        int[] idxStok = new int[100];

        TransaksiBarang tb = new TransaksiBarang();
        

        // Data Barang
        Barang brg1 = new Barang("001", "Beras Anak Raja", 74000, 20);
        Barang brg2 = new Barang("002", "Beras Idola", 72000, 20);
        Barang brg3 = new Barang("003", "Beras Sania", 65000, 20);
        Barang brg4 = new Barang("004", "Beras Sestra Ramos", 64000, 20);
        Barang brg5 = new Barang("005", "Beras Setra Wangi", 65500, 20);

        // menginput data Barang menuju tbtor
        tb.inputBarang(brg1, brg2, brg3, brg4, brg5);

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n================ TOKO BERAS ================");
            System.out.println("1. Tampilkan Barang");
            System.out.println("2. Lakukan Pembelian");
            System.out.println("3. Tampilkan Pembelian");
            System.out.println("4. Keluar Program");
            System.out.println("============================================");
            System.out.print("Pilihan Anda: ");
            pilihan = sc.nextInt();
            System.out.println("============================================\n");
            sc.nextLine();
            switch (pilihan) {
                case 1:
                    tb.tampilInputBarang();
                    break;
                case 2:
                System.out.println("================== PEMBELIAN ==================");        
                for (int i = 0; i < 100; i++) {
                    System.out.print("Masukkan Kode Beras : ");
                    tempKode = sc.next();
                    System.out.print("Jumlah yang ingin dibeli : ");
                    tempStok = sc.nextInt();
                    indexBarang = tb.mencariBarang(tb.brg, tempKode);
                    count++;
                    if (tempStok == 0) {
                        System.out.println("\n----------------------------------------------------------");
                        System.out.println("               ANDA TIDAK MEMBELI APAPUN!!");
                        System.out.println("----------------------------------------------------------\n");
                    } else if (tb.brg[indexBarang].stokBarang >= tempStok) {
                        tb.brg[indexBarang].stokBarang -= tempStok;
                        idxStok [i] = tempStok;
                        idxNama [i] = indexBarang;
                        countInvoice++;
                    } else if (tb.brg[indexBarang].stokBarang < tempStok) {
                        System.out.println("\n----------------------------------------------------------");
                        System.out.println("    STOK ' " + tb.brg[indexBarang].namaBarang
                                + " ' TIDAK MENCUKUPI");
                        System.out.println("----------------------------------------------------------\n");
                    }
                    System.out.print("Apakah Ingin Membeli Beras Lain ? (Y/T) : ");
                    String jawaban = sc.next();
                    if (jawaban.equals("t") || jawaban.equals("T")) {
                        break;
                    }
                } 
                break;
                case 3:
                System.out.println("-----------------------------------------------------");
                System.out.println("|                  BARANG BELANJAAN                 |");
                System.out.println("-----------------------------------------------------");
                System.out.println("|    Varietas Beras    |    Stok    |     Harga     |");
                System.out.println("-----------------------------------------------------");
                    for (int i = 0; i < countInvoice; i++) {
                        System.out.printf("| %-21s| %-11d| %-14d|\n", tb.brg[idxNama[i]].namaBarang, idxStok[i],  tb.brg[idxNama[i]].hargaBarang * idxStok[i]);
                        System.out.println("-----------------------------------------------------");
                    }
                break;
                case 4:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("            Program Selesai, Terima Kasih :D ");
                    System.out.println("----------------------------------------------------------");
                    break;
                default:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("                   PILIHAN TIDAK VALID !!");
                    System.out.println("----------------------------------------------------------\n");
            }
        } while (pilihan != 4);
    }
}
