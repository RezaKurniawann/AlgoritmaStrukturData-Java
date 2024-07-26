import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        Nasabah[] nsb = new Nasabah[3];

        nsb[1] = new Nasabah(1, "Reza", "Tangerang", 8131768, 1000000, 0f, true);
        nsb[2] = new Nasabah(2, "Kurniawan", "Malang", 8131760, 200000, 0f, true);
        
        System.out.println("======== BUKA REKENING ======== ");
        System.out.print("Masukkan id Rekening : ");
        int idRekening = sc.nextInt();

        int IndexAkun = CariIndex(nsb, idRekening);

        if (IndexAkun != -1) {
            boolean scanning = true;
            
            System.out.println("  ");

            System.out.println("========== DATA REKENING ==========");
            System.out.println("Nama        : " + nsb[idRekening].getNama());
            System.out.println("Alamat      : " + nsb[idRekening].getAlamat());
            System.out.println("No Handphone: " + nsb[idRekening].getnoHP());
            System.out.println("Saldo       : " + nsb[idRekening].lihatSaldo());
            
            while (scanning){
            System.out.println("\nApa yang ingin anda lakukan : (1 / 2 / 3 / 4 / 5)");
            System.out.println("1. Lihat Saldo  \n2. Deposit \n3. Tarik Tunai \n4. Berhutang \n5. Tutup Rekening");
            System.out.print("Masukkan pilihan : ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println("\n========== SALDO ==========");
                    System.out.print("Saldo Anda Adalah : ");
                    System.out.print(nsb[IndexAkun].lihatSaldo());
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("\n========== DEPOSIT ==========");
                    System.out.print("Masukkan Jumlah Deposit : ");
                    int depo = sc.nextInt();
                    nsb[IndexAkun].menabung(depo);
                    System.out.print("\nDeposit Sejumlah " + depo + " Berhasil ditambahkan!" );
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("\n========== TARIK TUNAI ==========");
                    System.out.print("Jumlah yang ingin ditarik : ");
                    int tarikTunai = sc.nextInt();
                    nsb[IndexAkun].tarikTunai(tarikTunai);
                    System.out.print("\nSejumlah " + tarikTunai + " Berhasil ditarik! " );
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("\n========== BERHUTANG ==========");
                    System.out.print("Masukkan jumlah hutang : ");
                    float hutang = sc.nextInt();

                    System.out.println("");
                    if (hutang < nsb[idRekening].saldo) {
                        System.out.println("Peminjaman Sejumlah " + hutang + " Disetujui!! ");

                        System.out.println("Cicilan yang harus dibayarkan adalah " + hutang / 6 + "per Bulan");

                    } else {
                        System.out.println("Peminjaman Sejumlah " + hutang + " Tidak Disetujui!! ");
                    }
                    break;
                case 5 :
                    System.out.println("\n========== Tutup Rekening ==========");
                    System.out.print("Anda yakin akan menutup rekening (y / Y) ? ");
                    char jwb = sc.next().charAt(0);
                    if (jwb == 'Y' || jwb == 'y') {
                        System.out.println("\nREKENING DITUTUP! Terima Kasih");
                        scanning = false;
                    } else {
                        System.out.println("\nTidak Jadi Menutup Rekening");
                        break;
                    }
            }
        } 
        } else {
            System.out.println("");
            System.out.println("ID Rekening Tidak Ditemukan!! ");
        }
    }

    static int CariIndex(Nasabah[] nsb, int idRekening) {
        for (int i = 0; i < nsb.length; i++) {
            if (nsb[i] != null && nsb[i].getIdRekening() == idRekening) {
                return i;
            }
        }
        return -1;
    }
}
