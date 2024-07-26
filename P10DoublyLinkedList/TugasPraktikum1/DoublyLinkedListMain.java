package TugasPraktikum1;

import java.util.Scanner;

public class DoublyLinkedListMain {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Scanner sd = new Scanner(System.in);

        DoublyLinkedList dll = new DoublyLinkedList();

        Boolean loop = true;
        while (loop = true) {
            dll.menu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nomor Antrian\t: ");
                    int nomor = sc.nextInt();
                    System.out.print("Nama Penerima\t: ");
                    String nama = sd.nextLine();
                    dll.addLast(nomor, nama);
                    sc.nextLine();
                    break;

                case 2:
                    dll.removeFirst();
                    dll.print();
                    break;

                case 3:
                    dll.print();
                    break;

                case 4:
                    loop = false;
                    break;

            }
        }
    }
}