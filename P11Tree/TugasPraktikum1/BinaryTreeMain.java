package TugasPraktikum1;

public class BinaryTreeMain {

    public static void main(String[] args) {
        BinaryTree BT = new BinaryTree();
        int[] data = { 6, 4, 8, 3, 5, 7, 9, 0, 0, 0 };
        int idxLast = 6;
        BT.populateData(data, idxLast);
        BT.traverseInOrder(0);

        System.out.println("\n-------------------------------");
        System.out.println("     Hasil Tugas NO 5          ");
        System.out.println("-------------------------------");
        BT.add(90);
        BT.add(72);
        System.out.println("method traverse PreOrder");
        BT.traversePreOrder(0);
        System.out.println();
        System.out.println("method traverse PostOrder");
        BT.traversePostOrder(0);
        System.out.println();
    }
}