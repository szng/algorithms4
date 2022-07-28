package Sort;

public class Sort {
    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    protected static boolean isSorted(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
