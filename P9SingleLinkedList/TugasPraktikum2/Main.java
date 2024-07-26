package TugasPraktikum2;

public class Main {
    public static void main(String[] args) {

        SingleLinkedList sll = new SingleLinkedList();

        sll.addFirst('A');
        sll.print();
        sll.addLast('B');
        sll.print();
        sll.insertAfter('B','C');
        sll.print();
        sll.insertAt(3,'E');
        sll.print();
        sll.insertBefore('E','D');
        sll.print();
    }
}
