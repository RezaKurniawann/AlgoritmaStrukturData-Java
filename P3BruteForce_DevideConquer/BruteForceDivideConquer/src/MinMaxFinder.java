class MinMaxFinder {
    
    static class Pair {
        int min;
        int max;
    }

    static Pair findMinMax(int[] arr, int low, int high) {
        Pair result = new Pair();
        Pair left = new Pair();
        Pair right = new Pair();

        // Jika hanya satu elemen dalam array
        if (low == high) {
            result.min = arr[low];
            result.max = arr[low];
            return result;
        }

        // Jika terdapat dua elemen dalam array
        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                result.min = arr[high];
                result.max = arr[low];
            } else {
                result.min = arr[low];
                result.max = arr[high];
            }
            return result;
        }

        // Jika terdapat lebih dari dua elemen dalam array, bagi menjadi dua bagian
        int mid = (low + high) / 2;
        left = findMinMax(arr, low, mid);
        right = findMinMax(arr, mid + 1, high);

        // Gabungkan hasil dari kedua sub-array
        if (left.min < right.min) {
            result.min = left.min;
        } else {
            result.min = right.min;
        }

        if (left.max > right.max) {
            result.max = left.max;
        } else {
            result.max = right.max;
        }

        return result;
    }
}