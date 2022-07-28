package Sort;

public class SelectionSort extends Sort {


    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {9, 8, 3, 4, 2, 1};
        SelectionSort.sort(a);
        for (Integer i : a) {
            System.out.print(i);
        }
    }
}
