public class MataKuliah {
    private String kodeMataKuliah;
    private String namaMataKuliah;
    private String dosenPengampu;
    private int kuotaKelas;
    private String[] daftarMahasiswa;
    private int jumlahMahasiswa;

    public MataKuliah(String kodeMataKuliah, String namaMataKuliah, String dosenPengampu, int kuotaKelas) {
        this.kodeMataKuliah = kodeMataKuliah;
        this.namaMataKuliah = namaMataKuliah;
        this.dosenPengampu = dosenPengampu;
        this.kuotaKelas = kuotaKelas;
        this.daftarMahasiswa = new String[kuotaKelas]; // Maksimum kuota kelas
        this.jumlahMahasiswa = 0; // Awalnya belum ada mahasiswa
    }

    public String getKodeMataKuliah() {
        return kodeMataKuliah;
    }

    public void setKodeMataKuliah(String kodeMataKuliah) {
        this.kodeMataKuliah = kodeMataKuliah;
    }

    public String getNamaMataKuliah() {
        return namaMataKuliah;
    }

    public void setNamaMataKuliah(String namaMataKuliah) {
        this.namaMataKuliah = namaMataKuliah;
    }

    public String getDosenPengampu() {
        return dosenPengampu;
    }

    public void setDosenPengampu(String dosenPengampu) {
        this.dosenPengampu = dosenPengampu;
    }

    public int getKuotaKelas() {
        return kuotaKelas;
    }

    public void tambahKuotaKelas(int jumlah) {
        kuotaKelas += jumlah;
    }

    public void kurangiKuotaKelas(int jumlah) {
        kuotaKelas -= jumlah;
    }

    public boolean tambahMahasiswa(String mahasiswa) {
        if (jumlahMahasiswa < kuotaKelas) {
            daftarMahasiswa[jumlahMahasiswa] = mahasiswa;
            jumlahMahasiswa++;
            return true;
        } else {
            System.out.println("Kuota kelas sudah penuh, tidak dapat menambah mahasiswa.");
            return false;
        }
    }

    public void tampilkanDaftarMahasiswa() {
        System.out.println("Daftar Mahasiswa dalam Kelas " + namaMataKuliah + ":");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("- " + daftarMahasiswa[i]);
        }
    }

    public void printInfoMataKuliah() {
        System.out.println("Informasi Mata Kuliah:");
        System.out.println("Kode Mata Kuliah: " + kodeMataKuliah);
        System.out.println("Nama Mata Kuliah: " + namaMataKuliah);
        System.out.println("Dosen Pengampu: " + dosenPengampu);
        System.out.println("Kuota Kelas: " + kuotaKelas);
        System.out.println("Daftar Mahasiswa:");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("- " + daftarMahasiswa[i]);
        }
    }

    public static void main(String[] args) {
        MataKuliah matkul1 = new MataKuliah("MK001", "Pemrograman Java", "Dosen A", 3);
        matkul1.tambahMahasiswa("Mahasiswa A");
        matkul1.tambahMahasiswa("Mahasiswa B");

        MataKuliah matkul2 = new MataKuliah("MK002", "Basis Data", "Dosen B", 2);
        matkul2.tambahMahasiswa("Mahasiswa X");

        System.out.println("Mata Kuliah 1:");
        matkul1.printInfoMataKuliah();

        System.out.println("\nMata Kuliah 2:");
        matkul2.printInfoMataKuliah();
    }
}
