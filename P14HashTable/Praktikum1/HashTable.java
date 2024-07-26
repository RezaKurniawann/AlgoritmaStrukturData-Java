package Praktikum1;

import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        this.dataMap = new Node[this.size];
    }

    public void printTable() {
        for (int i = 0; i < this.dataMap.length; i++) {
            System.out.println(i + ":");
            Node current = this.dataMap[i];
            while (current != null) {
                System.out.println("Key: " + current.key + ", Value: " + current.value);
                current = current.next;

            }
        }
    }

    public int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % this.dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int hash = this.hash(key);
        Node newNode = new Node(key, value);
        if (this.dataMap[hash] == null) {
            this.dataMap[hash] = newNode;
        } else {
            Node current = this.dataMap[hash];
            if (current.key == key) {
                current.value += value;
                return;
            }
            while (current.next != null) {
                current = current.next;
                if (current.key == key) {
                    current.value += value;
                    return;
                }
            }
            current.next = newNode;
        }
    }

    public int get(String key) {
        int hash = this.hash(key);
        Node current = this.dataMap[hash];
        while (current != null) {
            if (current.key == key)
                return current.value;
            current = current.next;
        }
        return 0;
    }

    public ArrayList keys() {
        ArrayList<String> keys = new ArrayList<>();
        for (int i = 0; i < this.dataMap.length; i++) {
            Node current = this.dataMap[i];
            while (current != null) {
                keys.add(current.key);
                current = current.next;
            }
        }
        return keys;
    }
    
    public void remove(String key) {
        int hash = this.hash(key);
        
        Node current = this.dataMap[hash];
        Node prev = null;
    
        // Cari node dengan key yang sesuai
        while (current != null && !current.key.equals(key)) {
            prev = current;
            current = current.next;
        }
    
        // Jika key ditemukan, hapus node
        if (current != null) {
            if (prev == null) {
                // Jika node yang dihapus adalah node pertama
                this.dataMap[hash] = current.next;
            } else {
                // Jika node yang dihapus berada di tengah atau akhir linked list
                prev.next = current.next;
            }
        }
    }
    

}
