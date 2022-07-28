package Sort;

public class ShellSort extends Sort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i ++) {
                for (int j = i; j >=h && less(a[j], a[j-h]); j -= h) {
                        exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {9, 8, 3, 4, 2, 1};
        ShellSort.sort(a);
        for (Integer i : a) {
            System.out.print(i);
        }
        System.out.println(isSorted(a));
    }
}
