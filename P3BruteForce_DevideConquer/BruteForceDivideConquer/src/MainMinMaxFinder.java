import java.util.Scanner;

public class MainMinMaxFinder {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("===================");
        System.out.print("Masukkan panjang array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("===================");
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan elemen array ke -" + (i + 1) + " : ");
            arr[i] = sc.nextInt();
            sc.nextLine();
        }

        MinMaxFinder.Pair result = MinMaxFinder.findMinMax(arr, 0, n - 1);
        System.out.println("===================");
        System.out.println("Nilai minimum: " + result.min);
        System.out.println("Nilai maksimum: " + result.max);

    }
}