package TugasPraktikum3;

public class Main {

  public static void main(String[] args) {
    SingleLinkedList sll = new SingleLinkedList();

    sll.push("Bahasa");
    sll.print();
    sll.push("Android");
    sll.print();
    sll.push("Komputer");
    sll.print();
    sll.push("Basis Data");
    sll.print();
    sll.push("Matematika");
    sll.print();
    sll.push("Algoritma");
    sll.print();
    sll.push("Statistika");
    sll.print();
    sll.push("Multimedia");
    sll.print();

    System.out.println("Hasil Akhir: ");
    sll.print();
    sll.peek();
  }
}