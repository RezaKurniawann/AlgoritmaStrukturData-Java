public class Nasabah {
    int id, noHP, saldo;
    String nama, alamat;
    float jmlHutang;
    boolean statusAktif;

    public Nasabah(int id,String nama,String alamat, int noHP, int saldo, float jmlHutang,boolean statusAktif){
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noHP = noHP;
        this.saldo = saldo;
        this.jmlHutang = jmlHutang;
        this.statusAktif = statusAktif;
    }
    public int getIdRekening() {
        return this.id;
    }
    public String getNama(){
        return this.nama;
    }
    public String getAlamat(){
        return this.alamat;
    }
    public int getnoHP(){
        return this.noHP;
    }
    public boolean getStatus(){
        return this.statusAktif;
    }
    public int lihatSaldo(){
        return this.saldo;
    }
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }
    public void setJmlHutang(int jmlHutang){
        this.jmlHutang = jmlHutang;
    }
    public void setStatus(boolean statusAktif){
        this.statusAktif = statusAktif;
    }
    public int menabung(int deposit){
        int temp = 0;
        temp += deposit;
        this.saldo += temp;
        return this.saldo;
    }
    public int tarikTunai(int jmlTarik){
        int temp = 0;
        temp += jmlTarik;
        this.saldo -= temp;
        return this.saldo;
    }   
}
