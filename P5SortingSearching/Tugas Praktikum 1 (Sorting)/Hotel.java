public class Hotel {
    String nama, kota;
    int harga, bintang;
    
    Hotel (String n, String k, int h, int b) {
        this.nama = n;
        this.kota = k;
        this.harga = h;
        this.bintang = b;
    }

    public void tampil() {
      
        System.out.println("Nama : " + nama);
        System.out.println("Kota : " + kota);
        System.out.println("Harga : " + harga);
        System.out.println("Bintang : " + bintang);
       
    } 


}
