package Praktikum1;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        // Menambahkan value ke dalam heap (dengan tipe List<Integer>)
        heap.add(value);

        // Simpan index value yang baru saja ditambahkan
        int current = heap.size() - 1;

        // Lakukan swap selama value yang baru saja ditambahkan lebih besar dari
        // parentnya
        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer remove() {
        // Cek ketika kondisi heap kosong
        if (heap.size() == 0) {
            return null;
        }

        // Cek ketika kondisi heap berisi 1 data
        if (heap.size() == 1) {
            return heap.remove(0);
        }

        // Simpan index nilai terbesar (root)
        int maxValue = heap.get(0);

        // Proses swap
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return maxValue;
    }

    private void sinkDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = index;

        // Ambil large kiri
        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        // Ambil large kanan
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        // Proses penyesuaian nilai pada heap
        if (largest != index) {
            swap(index, largest);
            sinkDown(largest);
        }
    }
}
