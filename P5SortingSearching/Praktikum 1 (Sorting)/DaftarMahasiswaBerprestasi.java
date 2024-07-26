public class DaftarMahasiswaBerprestasi {
    Mahasiswa listMhs[] = new Mahasiswa[5];
    int idx = 0;
    
    // method tambah()
    public void tambah(Mahasiswa m) {
        if(idx<listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }
    
    // method tampil()
    public void tampil() {
        // fungsi loop for berikut
        // akan melakukan looping
        // sejumlah objek didalam list
        // secara langsung
        for (Mahasiswa m : listMhs) {
            m.tampil();
            System.out.println("----------------------");
        }
    }

    // method selectionSort()
    public void selectionSort() {
        for(int i=0; i<listMhs.length-1; i++) {
            int idxMin = i;
            for(int j=i+1; j<listMhs.length; j++) {
                if(listMhs[j].ipk < listMhs[idxMin].ipk) {
                    idxMin = j;
                }
            }
            // swap
            Mahasiswa tmp = listMhs[idxMin];
            listMhs[idxMin] = listMhs[i];
            listMhs[i] = tmp;
        }
    }

    // method insertionSort()
    public void insertionSort() {
        for(int i=1; i<listMhs.length; i++) {
            Mahasiswa temp = listMhs[i];
            int j = i;
            while(j > 0 && listMhs[j-1].ipk > temp.ipk) {
                listMhs[j] = listMhs[j-1];
                j--;
            }
            listMhs[j] = temp;
        }
    }
}