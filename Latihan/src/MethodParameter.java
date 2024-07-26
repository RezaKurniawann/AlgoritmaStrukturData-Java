import java.util.Scanner;

public class MethodParameter {
    
    public static String siswa (String nm, int umr) {
        
        return "Nama : " + nm + ", Umur : " + umr;
    }
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        String nm;
        int umr;
        
        System.out.print ("Masukkan Nama : ");
        nm = sc.nextLine();
        System.out.print ("Masukkan Umur : ");
        umr = sc.nextInt();
        
        System.out.println ("===================");
        System.out.println (siswa (nm, umr));
        
           
    }
}
