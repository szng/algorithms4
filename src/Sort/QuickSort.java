package Sort;

public class QuickSort extends Sort {
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) {
                    break;
                }
            }
            while (less(a[lo], a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i < j) {
                exchange(a, i, j);
            } else {
                break;
            }
        }
        exchange(a, lo, j);
        return j; // 只能使用j作为中间标识, j是比枢轴小的一个数，后一个数比枢轴大
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void main(String[] args) {
        Integer[] a = {1, 9, 8, 3, 4, 2};
        QuickSort.sort(a,0, a.length-1);
        for (Integer i : a) {
            System.out.print(i);
        }
    }
}
