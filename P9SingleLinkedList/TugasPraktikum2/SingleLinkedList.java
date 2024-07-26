package TugasPraktikum2;

public class SingleLinkedList {
    Node head;
    Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if(!isEmpty()) {
            Node tmp = head;
            System.out.print("Isi Linked List:\t");
            while(tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Linked List Kosong!");
        }
    }

    public void addFirst(char input) {
        Node ndInput = new Node(input, null);
        if(isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    public void addLast(char input) {
        Node ndInput = new Node(input, null);
        if(isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void insertAfter(int key, char input) {
        Node ndInput = new Node(input, null);
        Node temp = head;
        do {
            if(temp.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if(ndInput.next == null) tail = ndInput;
                break;
            }
            temp = temp.next;
        } while(temp != null);
    }

    public void insertAt(int index, char input) {
        if(index < 0) {
            System.out.println("Indeks salah!");
        } else if(index == 0) {
            addFirst(input);
        } else {
            Node temp = head;
            for(int i = 0; i < index - 1; i++) {
                if(temp.next == null) break;
                temp = temp.next;
            }
            temp.next = new Node(input, temp.next);
            if(temp.next.next == null) tail = temp.next;
        }
    }
    
    public void insertBefore(int key, char input) {
        Node temp = new Node(input, null);
    
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
        } else if (head.data == key) {
            addFirst(input);
        } else {
            Node current = head;
            Node previous = null;
    
            while (current != null && current.data != key) {
                previous = current;
                current = current.next;
            }
    
            if (current != null) {
                previous.next = temp;
                temp.next = current;
            } else {
                System.out.println("Key tidak ditemukan.");
            }
        }
    }
}
