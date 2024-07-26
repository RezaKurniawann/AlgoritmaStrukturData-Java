import java.util.Scanner;
public class LatihanProsedurFungsi {
    
    public static void operasi (int a, int b) {
        int c;
        c = a + b;
        System.out.println("Hasil A + B adalah " + c);
    }
    
    public static void main (String [] args){
        int a, b;
        
        Scanner sc = new Scanner (System.in);
        System.out.print("Masukkan nilai a : ");
        a = sc.nextInt();
        System.out.print("Masukkan nilai b : ");
        b = sc.nextInt();
        
        System.out.println("\n--------------------------");
        System.out.println("Output : ");
        operasi(a, b);
        
    }
}
