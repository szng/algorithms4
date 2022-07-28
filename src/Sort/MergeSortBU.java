package Sort;

public class MergeSortBU extends Sort {
    private static Comparable[] aux;

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
//            if (i > mid) {
//                a[k] = aux[j++];
//            } else if (j > hi) {
//                a[k] = aux[i++];
//            } else if (less(aux[i], aux[j])) { // 不稳定的写法
//                a[k] = aux[i++];
//            } else {
//                a[k] = aux[j++];
//            }
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a,lo,lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {9, 8, 3, 4, 2, 1};
        MergeSortBU.sort(a);
        for (Integer i : a) {
            System.out.print(i);
        }
        System.out.println(isSorted(a));
    }
}
