public class Queue {

    public void menu () {
        System.out.println("============ Menu ===========");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Cetak Antrian");
        System.out.println("3. Hapus Antrian");
        System.out.println("4. Laporan Pengurutan Pesanan by Nama");
        System.out.println("5. Hitung Total Pendapatan");
        System.out.println("6. Keluar");
    }

    Pembeli[] data;
    int front;
    int rear;
    int size;
    int max;
    
    public Queue(int n) {
        max = n;
        data = new Pembeli[max];
        size = 0;
        front = rear = -1;
    }

    public boolean isFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(Pembeli dt) {
        if (isFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    public Pembeli Dequeue() {
        Pembeli dt = new Pembeli();
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            dt = data[front];
            size--;
            if (isEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Masih Kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println("|" + String.format("%-7s", data[i].antrian) + "|" + String.format("%-15s", data[i].namaPembeli) + "|" + String.format("%-10s", data[i].NoHp) + "|");
                i = (i + 1) % max;
            }           
            System.out.println("|" + String.format("%-7s", data[i].antrian) + "|" + String.format("%-15s", data[i].namaPembeli) + "|" + String.format("%-10s", data[i].NoHp) + "|");
            System.out.println("------------------------------------");
            System.out.println("Jumlah Antrian = " + size);
        }
    } 
    
    
}
