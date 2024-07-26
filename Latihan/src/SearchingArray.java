import java.util.Scanner;
public class SearchingArray {
    
    public static void main (String [] args) {
        
        Scanner sc = new Scanner (System.in);
        
        int [] a = {5, 3, 1, 6, 9, 8, 10, 11};
        int jml = a.length;
        int cari, count = 0;
        
        System.out.println ("Data : ");
        for (int i =  0; i < jml; i++) {
        System.out.print(a[i] + " ");
        }
        
        System.out.println("\nCari : ");
        cari = sc.nextInt();
        System.out.println ("\n-----------------------");
        System.out.println ("Hasil : ");
        
        for (int i =  0; i < jml; i++) {
            if (cari == a[i]) {
                System.out.println ("Data " + cari + " berada di index ke - " + i);
                
            }else {
                count++;
                if (count == jml) {
                    System.out.println ("Data " + cari + " Tidak dapat ditemukan!");
                }
            }
        }    
    }
}
