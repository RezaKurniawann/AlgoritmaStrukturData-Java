public class TransaksiBarang {

    Barang[] brg = new Barang[5];

    //input daftar barang
    void inputBarang (Barang... barangs) {
        for (int i = 0; i < barangs.length; i++) {
            brg[i] = barangs[i];
        }
    }

    //tampil daftar barang
    void tampilInputBarang () {
        System.out.println("----------------------------------------------------------");
        System.out.println("| Kode |    Varietas Beras    |    Harga    |    Stok    |");
        System.out.println("----------------------------------------------------------");
        for(Barang barangs : brg){
            barangs.tampil();
        }
        System.out.println("----------------------------------------------------------");
    }

    //mencari index Barang
    int mencariBarang(Barang[] barang, String tempKode) { 
        for (int i = 0; i < barang.length; i++) {
            if (barang[i].kodeBarang.equalsIgnoreCase(tempKode)) {            
                return i;
            }
        }
        return -1;
    }    
     

}
