public class ProsedurFungsi {
    
    //prosedur
    public static void siswa() {
        String nama = "Budi";
        int umur = 17;
        System.out.println("Nama  : " + nama + ", Umur : "+ umur);
    }
    
    //fungsi
    public static String siswi() {
        String nama = "Bunga";
        int umur = 16;
        return "Nama  : " + nama + ", Umur : "+ umur;
    }
    
    public static void main (String [] args) {
        System.out.println (siswi());
        siswa();
    }
}
