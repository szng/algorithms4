package Sort;

import java.util.Arrays;

public class MergeSort extends Sort {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
//            if (i > mid) {
//                aux[k] = a[j++];
//            } else if (j > hi) {
//                aux[k] = a[i++];
//            } else if (less(a[i], a[j])) {  //it is not stable
//                aux[k] = a[i++];
//            } else {
//                aux[k] = a[j++];
//            }
            if (i > mid) {
                aux[k] = a[j++];
            } else if (j > hi) {
                aux[k] = a[i++];
            } else if (less(a[j], a[i])) {  //it is stable
                aux[k] = a[j++];
            } else {
                aux[k] = a[i++];
            }
        }
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(aux, a, lo, mid);
        sort(aux, a, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }


    public static void main(String[] args) {
        Integer[] a = {9, 8, 3, 4, 2, 1};
        Integer[] aux = Arrays.copyOf(a, a.length);
        MergeSort.sort(aux, a, 0, a.length - 1);
        for (Integer i : a) {
            System.out.print(i);
        }
        for (Integer i : aux) {
            System.out.println(i);
        }
    }
}
