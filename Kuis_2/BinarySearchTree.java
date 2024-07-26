class BinarySearchTree {
    Node root;

    public void menu () {
        System.out.println("\n========== menu ==========");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Cari Buku (By ISBN)");
        System.out.println("3. Tampilkan Buku (Preorder)");
        System.out.println("4. Tampilkan Buku (Postorder)");
        System.out.println("5. Tampilkan Buku (Inorder)");
        System.out.println("6. Hapus Buku (By ISBN)");
        System.out.println("7. Exit");
        System.out.print("Pilih menu : ");
    }
    
    // public BinarySearchTree() {
    //     root = null;
    // }

    public void insert(Book book) {
        root = insertRec(root, book);
    }

    private Node insertRec(Node root, Book book) {
        if (root == null) {
            root = new Node(book);
            return root;
        }

        if (book.getIsbn() < root.book.getIsbn()) {
            root.left = insertRec(root.left, book);
        } else if (book.getIsbn() > root.book.getIsbn())
            root.right = insertRec(root.right, book);
    
        return root;
    }

    public Node searchByIsbn(int isbn) {
        return searchByIsbnRec(root, isbn);
    }

    private Node searchByIsbnRec(Node root, int isbn) {
        if (root == null || root.book.getIsbn() == isbn){
            return root;
        }
        if (isbn < root.book.getIsbn()){
            return searchByIsbnRec(root.left, isbn);
        }
        return searchByIsbnRec(root.right, isbn);
    }

    public void preorder() {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.book.getTitle() + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public void postorder() {
        postorderTraversal(root);
    }

    private void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.book.getTitle() + " ");
        }
    }

    public void inorder() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.book.getTitle() + " ");
            inorderTraversal(root.right);
        }
    }

    public void deleteByIsbn(int isbn) {
        root = deleteByIsbnRec(root, isbn);
    }

    private Node deleteByIsbnRec(Node root, int isbn) {
        if (root == null) {
            System.out.println("Buku tidak ditemukan.");
            return root;
        }

        if (isbn < root.book.getIsbn()) {
            root.left = deleteByIsbnRec(root.left, isbn);
        } else if (isbn > root.book.getIsbn()) {
            root.right = deleteByIsbnRec(root.right, isbn);
        } else {
            if (root.left == null) {
                System.out.println("Buku berhasil dihapus");
                return root.right;
            } else if (root.right == null) {
                System.out.println("Buku berhasil dihapus");
                return root.left;
            }
            root.book = minValueNode(root.right).book;
            root.right = deleteByIsbnRec(root.right, root.book.getIsbn());
            System.out.println("Buku berhasil dihapus");
        }
        return root;
    }

    private Node minValueNode(Node root) {
        Node current = root;
        while (current.left != null)
            current = current.left;
        return current;
    }
}