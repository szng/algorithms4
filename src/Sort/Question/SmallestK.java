package Sort.Question;

import Sort.QuickSort;

/**
 * leetcode 17.14
 */
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int lo = 0, hi = arr.length - 1;
        if (hi - lo + 1 <= k) {
            return arr;
        }
        quickSort(arr, lo, hi, k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public void quickSort(int[] arr, int lo, int hi, int count) {
        int i = lo, j = hi + 1;
        int temp = arr[lo];
        while (true) {
            while (arr[++i] < temp) {
                if (i == hi) {
                    break;
                }
            }
            while (arr[--j] > temp) {
                if (j == lo) {
                    break;
                }
            }
            if (i < j) {
                int a = arr[i];
                arr[i] = arr[j];
                arr[j] = a;
            } else {
                break;
            }
        }
        arr[lo] = arr[j];
        arr[j] = temp;
        if (j - lo + 1 == count) {
            return;
        } else if (j - lo + 1 > count) {
            quickSort(arr, lo, j - 1, count);
        } else {
            quickSort(arr, j + 1, hi, count - (j - lo + 1));
        }
    }

    public static void main(String[] args) {
        SmallestK a = new SmallestK();
        int[] arr = {1,3,5,7,2,4,6,8};
        int[] result = a.smallestK(arr, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
