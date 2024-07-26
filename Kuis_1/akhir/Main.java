import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Mediator media = new Mediator();

        int pilihan, indexBarang, indexTujuan, tempStok, jumlahPendapatan = 0, totalStok = 0, totalOngkir = 0, totalHargaBarang = 0, count = 0;
        String idBarang, idTujuan, username = "reza", password = "25", inputUsername, inputPassword;

        int[] listItem = new int[100];
        int[] listDestination = new int[100];
        int[] listStock = new int[100];

        // Data item
        Item itm1 = new Item("001", "Beras Anak Raja", 64500, 20);
        Item itm2 = new Item("002", "Beras Idola", 72000, 20);
        Item itm3 = new Item("003", "Beras Sania", 65000, 20);
        Item itm4 = new Item("004", "Beras Sestra Ramos", 64000, 20);
        Item itm5 = new Item("005", "Beras Setra Wangi", 65500, 20);
        Item itm6 = new Item("006", "Beras Si Pulen", 103000, 20);
        Item itm7 = new Item("007", "Beras Sumo", 87000, 20);

        // menginput data item menuju mediator
        media.inputItem(itm1, itm2, itm3, itm4, itm5, itm6, itm7);

        // Tujuan
        Destination dstn1 = new Destination("101", "Blimbing", 3000); // 3,3
        Destination dstn2 = new Destination("102", "Kedungkandang", 7000); // 7,5
        Destination dstn3 = new Destination("103", "Klojen", 6000); // 6,4
        Destination dstn4 = new Destination("104", "Lowokwaru", 4000); // 4
        Destination dstn5 = new Destination("105", "Sukun", 8000); // 8,3

        // mengirim data destination ke mediator
        media.inputDestination(dstn1, dstn2, dstn3, dstn4, dstn5);

        Scanner reza = new Scanner(System.in);

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("======================= MENU LOGIN =======================");
            System.out.print("Masukkan Username: ");
            inputUsername = reza.nextLine();
            System.out.print("Masukkan Password: ");
            inputPassword = reza.nextLine();
            if (username.equalsIgnoreCase(inputUsername) && password.equalsIgnoreCase(inputPassword)) {
                do {
                    System.out.println("\n================ PROGRAM DISTRIBUSI BERAS ================");
                    System.out.println("1. Lihat Inventory Beras");
                    System.out.println("2. Ubah Stock Beras");
                    System.out.println("3. Lakukan Pengiriman ");
                    System.out.println("4. Cetak Laporan");
                    System.out.println("5. Keluar Program");
                    System.out.println("==========================================================");
                    System.out.print("Pilihan Anda: ");
                    pilihan = reza.nextInt();
                    System.out.println("==========================================================\n");
                    reza.nextLine();
                    switch (pilihan) {
                        case 1:
                            media.tampilInputItem();
                            break;
                        case 2:
                            System.out.println("================== UPDATE STOK BARANG ==================");
                            System.out.print("Masukkan ID Beras : ");
                            idBarang = reza.next();
                            System.out.print("Masukkan Stok Barang yang Baru : ");
                            tempStok = reza.nextInt();
                            indexBarang = media.mencariItem(media.barang, idBarang);
                            media.barang[indexBarang].stokBarang = tempStok;
                            media.tampilInputItem();
                            break;
                        case 3:
                            int[] idxInvoiceNama = new int[100];
                            int[] idxInvoiceStok = new int[100];
                            int[] idxInvoiceHarga = new int[100];
                            int countInvoice = 0, invoiceStok = 0, invoiceHarga = 0;
                            for (int i = 0; i < 100; i++) {
                                media.tampilInputDestination();
                                System.out.print("Masukkan ID Tujuan : ");
                                idTujuan = reza.next();
                                System.out.println();
                                media.tampilInputItem();
                                System.out.print("Masukkan ID Beras : ");
                                idBarang = reza.next();
                                System.out.println();
                                System.out.print("Masukkan Jumlah yang Ingin Dikirim : ");
                                tempStok = reza.nextInt();
                                indexBarang = media.mencariItem(media.barang, idBarang);
                                indexTujuan = media.mencariDestination(media.tujuan, idTujuan);
                                count++;
                                if (tempStok == 0) {
                                    System.out.println("\n----------------------------------------------------------");
                                    System.out.println("               ANDA TIDAK MENGIRIM APAPUN !!");
                                    System.out.println("----------------------------------------------------------\n");
                                } else if (media.barang[indexBarang].stokBarang >= tempStok) {

                                    media.barang[indexBarang].stokBarang -= tempStok;
                                    
                                    listStock[count] = tempStok; //L
                                    listItem[count] = indexBarang; //L
                                    listDestination[count] = indexTujuan; //L
                                
                                    totalStok += tempStok; //L
                                    totalOngkir += media.tujuan[listDestination[count]].ongkosPengiriman; //L
                                    totalHargaBarang += (media.barang[listItem[count]].hargaBarang * listStock[count]); //L
                                    jumlahPendapatan = totalHargaBarang - totalOngkir; //L

                                    idxInvoiceHarga[countInvoice] = media.barang[indexBarang].hargaBarang;//i
                                    idxInvoiceNama[countInvoice] = indexBarang;//i
                                    idxInvoiceStok[countInvoice] = tempStok;//i
                                    invoiceHarga += media.barang[indexBarang].hargaBarang * tempStok;/// perubahan rumus //i
                                    invoiceStok += tempStok;//i
                                
                                    countInvoice++;
                                } else if (media.barang[indexBarang].stokBarang < tempStok) {
                                    System.out.println("\n----------------------------------------------------------");
                                    System.out.println("    STOK ' " + media.barang[indexBarang].namaBarang
                                            + " ' TIDAK MENCUKUPI");
                                    System.out.println("----------------------------------------------------------\n");
                                }
                                System.out.print("\nApakah Ingin Mengirim Barang Lain ? (Y/T) : ");
                                String jawaban = reza.next();
                                if (jawaban.equals("t") || jawaban.equals("T")) {
                                    break;
                                }
                            }

                            System.out.println("-----------------------------------------------------");
                            System.out.println("|    Varietas Beras    |    Stok    |     Harga     |");
                            System.out.println("-----------------------------------------------------");
                            for (int i = 0; i < countInvoice; i++) {
                                System.out.printf("| %-21s| %-11d| %-14d|\n", media.barang[idxInvoiceNama[i]].namaBarang, idxInvoiceStok[i],  idxInvoiceHarga[i]);
                                System.out.println("-----------------------------------------------------");
                            }
                            System.out.printf("|        TOTAL         | %-11d| %-14d|\n", invoiceStok, invoiceHarga);
                            System.out.println("-----------------------------------------------------");
                            break;
                        case 4:
                            System.out.println("\n======================== LAPORAN =======================");
                            System.out.println("------------------------------------------------------------------------------------");
                            System.out.println("|    Varietas Beras    |      Tujuan      |    Stok    |     Harga     |   Ongkir  |");
                            System.out.println("------------------------------------------------------------------------------------");
                            for (int i = 1; i <= count; i++) {
                                if (listStock[i] != 0) {
                                    System.out.printf("| %-21s| %-17s| %-11d| %-14d| %-10d|\n",
                                            media.barang[listItem[i]].namaBarang,
                                            media.tujuan[listDestination[i]].namaTujuan, listStock[i],
                                            media.barang[listItem[i]].hargaBarang,
                                            media.tujuan[listDestination[i]].ongkosPengiriman);
                                    System.out.println("------------------------------------------------------------------------------------");
                                }
                            }
                            System.out.printf("|                  TOTAL                  | %-11d| %-14d| %-10d|\n", totalStok, totalHargaBarang, totalOngkir);
                            System.out.println("------------------------------------------------------------------------------------");
                            System.out.printf("|             Jumlah PENDAPATAN           |                   %-21d|\n", jumlahPendapatan);
                            System.out.println("------------------------------------------------------------------------------------");
                            break;
                        case 5:
                            System.out.println("----------------------------------------------------------");
                            System.out.println("            Program Selesai, Terima Kasih :D ");
                            System.out.println("----------------------------------------------------------");
                            break;
                        default:
                            System.out.println("----------------------------------------------------------");
                            System.out.println("                   PILIHAN TIDAK VALID !!");
                            System.out.println("----------------------------------------------------------\n");
                    }
                } while (pilihan != 5);
            } else {
                System.out.println("\n----------------------------------------------------------");
                System.out.println("            USERNAME ATAU PASSWORD ANDA SALAH !!");
                System.out.println("----------------------------------------------------------\n");
            }
        }
    }
}
