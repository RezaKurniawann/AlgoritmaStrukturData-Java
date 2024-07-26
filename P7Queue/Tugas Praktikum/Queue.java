public class Queue {
    Pembeli antrian [];
    int front, rear, size, max;

    public Queue(int n) {
        max = n;
        antrian = new Pembeli [max];
        size = 0;
        front = rear = -1;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }
    public void peek() {
        if (!isEmpty()) {
            System.out.println("Antrian terdepan: " + antrian[front].nama
                    + " " + antrian[front].noHP);
        } else {
            System.out.println("Antrian masih kosong");
        }
    }
    public void print() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(antrian[i].nama
                        + " " + antrian[i].noHP);
                i = (i + 1) % max;
            }           
            System.out.println(antrian[i].nama
                    + " " + antrian[i].noHP);
            System.out.println("Jumlah elemen = " + size);
        }
    }
    public void clear() {
        if (!isEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Antrian behasil dikosongkan");
        } else {
            System.out.println("Antrian masih kosong");
        }
    }
    public void enqueue(Pembeli dt) {
        if (isFull()) {
            System.out.println("Antrian sudah penuh");           
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
            antrian[rear] = dt;
            size++;
        }
    }
    
    public Pembeli dequeue() {
        Pembeli dt = new Pembeli();
        if (isEmpty()) {
            System.out.println("Antrian masih kosong");            
        } else {
            dt = antrian[front];
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
    public void peekRear() {
        if (!isEmpty()) {
            System.out.println("Antrian Paling Belakang : " + antrian[rear].nama
                    + " " + antrian[rear].noHP);
        } else {
            System.out.println("Queue masih kosong");
        }
    }
    public int cariUrutanAntrian(String nama) {
        for (int i = 0; i < size; i++) {
            if (antrian[i] != null && antrian[i].nama.equalsIgnoreCase(nama)) {
                return i + 1; // Mengembalikan urutan antrian (1-based index)
            }
        }
        return -1; // Mengembalikan -1 jika nama tidak ditemukan
    }
    
    
}