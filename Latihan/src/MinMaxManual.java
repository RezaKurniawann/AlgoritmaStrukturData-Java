
public class MinMaxManual {
    
    public static void main (String [] args) {
        int [] a = {1, 3, 5, 6, 7};
        int max = a [0], min = a [0];
        int jml = a.length;
        
        for ( int i = 0; i < jml; i++) {
            if (max < a [i]) {
                max = a[i];
            }
            if (min > a [i]) {
                min = a[i];
            }
        }
        System.out.println (max);
        System.out.println(min);
    }
}
