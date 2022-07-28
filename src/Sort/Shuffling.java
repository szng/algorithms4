package Sort;

import java.util.Random;

/**
 * 到数组第i位时，前面的i-1中随机的一位进行交换
 */
public class Shuffling extends Sort {
    public static void sort(Comparable[] comparables) {
        int N = comparables.length;
        for (int i = 1; i < N; i++) {
            Random r = new Random();
            exchange(comparables, i, r.nextInt(i));
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Shuffling.sort(a);
        for (Integer i : a) {
            System.out.println(i);
        }
        assert !isSorted(a);
    }
}
