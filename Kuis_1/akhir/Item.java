public class Item {
    
    String id, namaBarang;
    int hargaBarang, stokBarang;
    
    public Item (String id, String namaBarang, int hargaBarang, int stokBarang) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.stokBarang = stokBarang;
    }

    void tampil() {
        System.out.printf("| %-5s| %-21s| %-12d| %-11d|\n", id, namaBarang, hargaBarang, stokBarang);
    }



    
}