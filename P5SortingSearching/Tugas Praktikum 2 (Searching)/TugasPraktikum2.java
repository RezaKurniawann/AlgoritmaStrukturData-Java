import java.util.Scanner;

public class TugasPraktikum2 {

    public static void main(String[] args) {
        Scanner reza = new Scanner(System.in);

        int data[] = {9, 3, 6, 4, 5, 8, 6, 2, 1, 7, 1, 2};
        System.out.println("=== Data sebelum diurutkan ===");
        for (int m : data) {
            System.out.print(m + " ");
        }

        bubbleSort(data);

        System.out.println("\n\n=== Data setelah diurutkan ===");
        for (int m : data) {
            System.out.print(m + " ");
        }

        System.out.print("\n\nMasukkan Angka yang ingin dicari : ");

        int target = reza.nextInt();
        int[] results = binarySearch(data, target);

        if (results.length == 0) {
            System.out.println("\nAngka " + target + " tidak ditemukan.");
        } else {
            System.out.println("\nAngka " + target + " ditemukan di indeks berikut:");
            for (int result : results) {
                System.out.print(result + " ");
            }
        }
    }

    // Descending Bubble Sort
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Binary Search
    public static int[] binarySearch(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        int[] indices = new int[arr.length];
        int count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                indices[count] = mid;
                count++;
                left = mid + 1;
            } else if (arr[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int[] results = new int[count];
        for (int i = 0; i < count; i++) {
            results[i] = indices[i];
        }

        return results;
    }
}

