package Sort;

public class HeapSort extends Sort {
    public static void sort(Comparable[] a) {
        int N = a.length - 1;
        for (int i = N / 2; i >= 0; i--) {
            sink(a, i, N);
        }
        while (N > 0) {
            exchange(a, 0, N--);
            sink(a, 0, N);
        }
    }

    public static void sink(Comparable[] a, int i, int N) {
        while (2 * i + 1 <= N) {
            int j = 2 * i + 1;
            if (j < N && less(a[j], a[j + 1])) {
                j++;
            }
            if (!less(a[i], a[j])) {
                break;
            }
            exchange(a, i, j);
            i = j;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 6, 5, 7, 8, 4, 3, 2, 9};
        sort(a);
        for (Integer i : a) {
            System.out.println(i);
        }
    }
}
