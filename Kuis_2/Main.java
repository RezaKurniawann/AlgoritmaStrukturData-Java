import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        
        Boolean loop = true;
        while (loop == true) {
            bst.menu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("==========================");
                    System.out.print("Masukkan judul buku: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String author = scanner.nextLine();
                    System.out.print("Masukkan tahun terbit: ");
                    int year = scanner.nextInt();
                    System.out.print("Masukkan ISBN: ");
                    int isbn = scanner.nextInt();
                    Book newBook = new Book(title, author, year, isbn);
                    bst.insert(newBook);
                    System.out.println("Buku berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.print("Masukkan ISBN buku yang ingin dicari: ");
                    int searchIsbn = scanner.nextInt();
                    Node foundNode = bst.searchByIsbn(searchIsbn);
                    if (foundNode != null) {
                        System.out.println("\n===== BUKU DITEMUKAN =====");
                        System.out.println("Title : " + foundNode.book.getTitle());
                        System.out.println("Author : " + foundNode.book.getAuthor());
                        System.out.println("Tahun : " + foundNode.book.getYear());
                        System.out.println("ISBN : " + foundNode.book.getIsbn());
                    } else
                        System.out.println("Buku tidak ditemukan.");
                    break;

                case 3:
                    System.out.println("\nDaftar buku (Preorder):");
                    bst.preorder();
                    break;

                case 4:
                    System.out.println("\nDaftar buku (Postorder):");
                    bst.postorder();
                    break;

                case 5:
                    System.out.println("\nDaftar buku (Inorder):");
                    bst.inorder();
                    break;

                case 6:
                    System.out.print("Masukkan ISBN buku yang ingin dihapus: ");
                    int deleteIsbn = scanner.nextInt();
                    bst.deleteByIsbn(deleteIsbn);
                    break;

                case 7:
                    System.out.println("Terima kasih!");
                    loop = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
