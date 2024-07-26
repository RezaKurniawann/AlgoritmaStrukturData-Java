import java.util.Scanner;
public class StrukBelanjaMain {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
      Scanner sd = new Scanner(System.in);

        System.out.println("----------------------------------");
        System.out.println("      History Struk Belanja       ");
        System.out.println("----------------------------------");
        System.out.println();
        System.out.print("Masukkan Banyak Struk\t: ");
        int banyak = sc.nextInt();
        System.out.println();
        Belanja blj = new Belanja(banyak);

        int totalHarga = 0;
        int jml, harga;
        for (int i = 0; i < banyak; i++) {
        System.out.print("Nomor Transaksi\t\t: ");
        int nt =sc.nextInt();
        System.out.print("Tanggal Pembelian\t: ");
        String tanggal =sd.nextLine();
        System.out.print("Nama Barang\t\t: ");
        String nb =sd.nextLine();
        System.out.print("Jumlah Barang\t\t: ");
        jml = sc.nextInt();
        System.out.print("Harga Barang\t\t: ");
        harga = sc.nextInt();
        totalHarga =jml * harga;
        StrukBelanja sb = new StrukBelanja(nt, tanggal, nb, jml,harga);
        blj.push(sb);
        System.out.print("Total Harga\t\t: "+ totalHarga);
        System.out.println("\n");
        }

    char pilih;
    do{
        System.out.println("------------------------------------");
        System.out.println("             PILIHAN MENU           ");
        System.out.println("------------------------------------");
        System.out.println(" 1. menampilkan struk teratas\n 2. ambil 5 struk untuk mendapatkan kupon\n 3. lihat sisa struk\n 4. keluar\n");
        
        System.out.print("Pilih Menu (masukkan angka 1-4)");
        int pilihan =sc.nextInt();
        System.out.println("------------------------------------------------");
    
        switch (pilihan){
            case 1:
                blj.peek();
                blj.print();
                break;
            case 2:
                blj.pop();
                blj.pop();
                blj.pop();
                blj.pop();
                blj.pop();
                break;
            case 3:
                blj.print();
                break;
            case 4:
                System.out.println("Terima Kasih");
                break;
            default:
                System.out.println("Menu yang anda masukkan salah");
                break;
        }if(pilihan == 4) {
            pilih = 't';
        }else{
            System.out.print("Kembali ke menu Utama (y/t) : ");
            pilih = sc.next().charAt(0);
        }
    }while(pilih == 'y');
    }
}