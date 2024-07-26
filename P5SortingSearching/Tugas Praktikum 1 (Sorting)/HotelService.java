public class HotelService {
    Hotel rooms[] = new Hotel[5];
    int idx = 0;  

    // method tambah()
    public void tambah(Hotel h) {
        if(idx < rooms.length) {
            rooms[idx] = h;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }

    //method tampill all
    public void tampil() {
        for (Hotel h : rooms) {
            h.tampil();
            System.out.println("----------------------");
        }
    }

    // method selectionSort()
    public void selectionSort() {
        for(int i=0; i < rooms.length-1; i++) {
            int idxMin = i;
            for(int j=i+1; j<rooms.length; j++) {
                if(rooms[j].harga < rooms[idxMin].harga) {
                    idxMin = j;
                }
            }
            // swap
            Hotel tmp = rooms[idxMin];
            rooms[idxMin] = rooms[i];
            rooms[i] = tmp;
        }
    }

    // method insertionSort()
    public void insertionSort() {
        for(int i=1; i<rooms.length; i++) {
            Hotel temp = rooms[i];
            int j = i;
            while(j > 0 && rooms[j-1].bintang < temp.bintang) {
                rooms[j] = rooms[j-1];
                j--;
            }
            rooms[j] = temp;
        }
    }
}


