public class PencarianMhs {
    Mahasiswa listMhs[] = new Mahasiswa[5];
    int idx;
    
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
    
    // method findSeqSearch()
    public int findSeqSearch(int cari) {
        int posisi = -1;
        for(int j=0; j < listMhs.length; j++) {
            if(listMhs[j].nim==cari) {
                posisi = j;
            }
        }
        return posisi;
    }
    
    // method tampilPosisi()
    public void tampilPosisi(int x, int pos) {
        if(pos!=-1) {
            System.out.println("data : "+ x +"ditemukan pada indeks " + pos);
        } else {
            System.out.println("data : "+ x +"tidak ditemukan");
        }
    }
    
    // method tampilData()
    public void tampilData(int x, int pos) {
        if(pos!=-1) {
            System.out.println("Nim\t : " + x);
            System.out.println("Nama\t : " + listMhs[pos].nama);
            System.out.println("Umur\t : " + listMhs[pos].umur);
            System.out.println("IPK\t : " + listMhs[pos].ipk);
        } else {
            System.out.println("data : "+ x +"tidak ditemukan");
        }
    }

    public int findBinarySearch(int cari, int left, int right) {
        // method ini berlaku untuk sorting ascending
        int mid;
        if(right >= left) {
            mid = (left + right) / 2;
            if(cari == listMhs[mid].nim) {
                return mid;
            } else if(listMhs[mid].nim > cari) {
                return findBinarySearch(cari, left, mid - 1); // rekursif
            } else {
                return findBinarySearch(cari, mid + 1, right); // rekursif
            } 
        } return -1;
    }
}