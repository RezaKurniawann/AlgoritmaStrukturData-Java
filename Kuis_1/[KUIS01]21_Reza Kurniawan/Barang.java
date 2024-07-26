public class Barang {
    String kodeBarang, namaBarang;
    int hargaBarang, stokBarang;
    
    public Barang (String kodeBarang, String namaBarang, int hargaBarang, int stokBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.stokBarang = stokBarang;
    } 
    
    void tampil() {
        System.out.printf("| %-5s| %-21s| %-12d| %-11d|\n", kodeBarang, namaBarang, hargaBarang, stokBarang);
    }
}



// void tampil() {
//     System.out.printf("| %-5s| %-21s| %-12d| %-11d|\n", id, namaBarang, hargaBarang, stokBarang);
// }
