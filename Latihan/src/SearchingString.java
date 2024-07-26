import java.util.Scanner;

public class SearchingString {
    
    public static void main (String [] args) {
        
        Scanner sc = new Scanner (System.in);
        String cari;
        int count = 0;
        String [] a = {
            "Reza",
            "Kurniawan",
            "Nadila",
            "Ananda",
        };
        
        System.out.println("========= Data Nama ========");
        for (int i = 0; i < a.length; i++){
            System.out.println(i + 1 + ". " + a[i]);
        }
        
        System.out.println("============================");
        System.out.print("Cari : ");
        cari = sc.nextLine();
        System.out.println ("--------");
        System.out.println ("Hasil : ");
        for (int i = 0; i < a.length; i++){
            if (cari.equalsIgnoreCase(a[i])) {
                System.out.println ("Data " + cari + " Berada di index ke - " + i);
            } else {
                count++;
                if (count == a.length) {
                    System.out.println ("Data " + cari + " Tidak dapat ditemukan!");
                }
                        
            }
        }
        
        
        
        
        
    }
}
