package TugasPraktikum1;

public class BinaryTree {
    Node root;
    int[] data;
    int idxLast;

    public BinaryTree() {
        data = new int[10];
    }

    void populateData(int data[], int idxLast) {
        this.data = data;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traverseInOrder(2 * idxStart + 1);
            System.out.print(data[idxStart] + " ");
            traverseInOrder(2 * idxStart + 2);
        }
    }

    // SOAL No 5
    void add(int data) {
        if (idxLast == this.data.length - 1) {
            System.out.println("Tree Array sudah Penuh");
        } else {
            this.data[++idxLast] = data;
        }
    }

    void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            System.out.print(" " + data[idxStart]);
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }

    void traversePostOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traversePostOrder(2 * idxStart + 1);
            traversePostOrder(2 * idxStart + 2);
            System.out.print(" " + data[idxStart]);
        }
    }

    void addNodeRekursif(int key) {
        root = addNodeRekursif(root, key);
    }

    public Node addNodeRekursif(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        if (data < current.data) {
            current.left = addNodeRekursif(current.left, data);
        } else if (data > current.data) {
            current.right = addNodeRekursif(current.right, data);
        } else {
            return current;
        }
        return current;
    }

    void maksimal() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.println(current.data);
    }

    void minimal() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        System.out.println(current.data);
    }

    void printLeft(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.print(" " + root.data);
            return;
        }
        if (root.left != null) {
            printLeft(root.left);
        }
        if (root.right != null) {
            printLeft(root.right);
        }
    }

    int jumlahLeft() {
        return jumlahLeft(root);
    }

    int jumlahLeft(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return jumlahLeft(node.left) + jumlahLeft(node.right);
        }
    }

}
