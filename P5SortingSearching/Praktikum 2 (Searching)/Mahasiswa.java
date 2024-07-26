public class Mahasiswa {
    public int nim;
    public String nama;
    public int umur;
    public double ipk;
    
    Mahasiswa(int ni, String n, int u, double i) {
        this.nim = ni;
        this.nama = n;
        this.umur = u;
        this.ipk = i;
    }
    
    public void tampil() {
        System.out.println("Nim = "+nim);
        System.out.println("Nama = "+nama);
        System.out.println("Umur = "+umur);
        System.out.println("IPK = "+ipk);
    }
}