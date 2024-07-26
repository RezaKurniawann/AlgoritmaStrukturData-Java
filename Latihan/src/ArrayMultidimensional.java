
public class ArrayMultidimensional {
    public static void main (String [] args){
        
    String [][] kontak = {
        {"Reza", " 0813***"},
        {"Kurniawan", " 0812***", " aselole"},
        {"Awan", " 0811***"}
    
    };
    
    for (int j = 0; j < kontak.length; j++) {
        for (int k = 0; k < kontak[j].length; k++) {
            System.out.print (kontak[j][k]);
        }
    System.out.println();
    }
    }
}
