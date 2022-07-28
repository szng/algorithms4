package Sort.Question;

/**
 * leetcode 面试题16.16
 */
public class SubSort {
    public int[] subSort(int[] array) {
        int j = array.length - 1;
        int[] result = {-1, -1};
        if (j < 0) {
            return result;
        }
        int max = array[0];
        for (int i = 0; i <= j; i++) {
            if (array[i] < max) {
                result[1] = i;
            } else {
                max = array[i];
            }
        }
        int min = array[j];
        for (int i = j; j >= 0; j--) {
            if (array[j] > min) {
                result[0] = j;
            } else {
                min = array[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,3,9,7,5};
        SubSort a = new SubSort();
        int[] result = a.subSort(array);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
