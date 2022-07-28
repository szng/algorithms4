package Sort;

public class InsertionSort extends Sort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exchange(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {9, 8, 3, 4, 2, 1};
        InsertionSort.sort(a);
        for (Integer i : a) {
            System.out.print(i);
        }
    }
}
