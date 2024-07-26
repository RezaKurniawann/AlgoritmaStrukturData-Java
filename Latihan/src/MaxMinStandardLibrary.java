import java.util.Arrays;
import java.util.Collections;

public class MaxMinStandardLibrary {
    public static void main(String[] args) {
    Integer [] a = { 1, 2, 5, 3, 4 };
    
    // secara otomatis
    int maks = Collections.max(Arrays.asList(a));
    int min = Collections.min(Arrays.asList(a));
    
    Arrays.sort(a); // untuk mengurutkan secara ascending
    
    for (int i = 0; i < a.length; i++) {
        System.out.print(a[i] + " ");
    }
    System.out.println(Arrays.toString(a));
    System.out.println();
    
    System.out.println(maks);
    System.out.println(min);
    }  
}
