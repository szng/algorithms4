package Sort;

public class Quick3way extends Sort {
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = v.compareTo(a[i]);
            if (cmp < 0) {
                exchange(a, i, gt--);
            } else if (cmp > 0) {
                exchange(a, i++, lt++);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Integer[] a = {9, 8, 3, 4, 2, 1};
        Quick3way.sort(a);
        for (Integer i : a) {
            System.out.print(i);
        }
    }
}
