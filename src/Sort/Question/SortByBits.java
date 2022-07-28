package Sort.Question;

import java.util.*;

/**
 * leetcode 1356
 */
public class SortByBits {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int x = o1, y = o2;
                int i = 0, j = 0;
                while (x != 0) {
                    i += x & 1;
                    x = x >> 1;
                }
                while (y != 0) {
                    j += y & 1;
                    y = y >> 1;
                }
                if (i == j) {
                    return o1 - o2;
                }
                return i - j;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        SortByBits a = new SortByBits();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] result = a.sortByBits(arr);
        for (int x : result) {
            System.out.println(x);
        }
    }
}
