public class Destination {
    
    String id, namaTujuan;
    int ongkosPengiriman;

    public Destination (String id, String namaTujuan, int ongkosPengiriman ) {
        this.id = id;
        this.namaTujuan = namaTujuan;
        this.ongkosPengiriman = ongkosPengiriman;
    }

    void tampil () {
    System.out.printf("| %-7s| %-15s| %-21d|\n", id, namaTujuan, ongkosPengiriman);
    }
}
