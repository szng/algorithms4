package Mathmethica;

import java.util.Arrays;
import java.util.Random;

public class Question384 {
    private int[] origin;
    public Question384(int[] nums) {
        origin = nums;
    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        int n = origin.length;
        int[] nums = Arrays.copyOf(origin, n);
        for (int i = 0; i < n; i++) {
            Random r = new Random();
            int temp = nums[i];
            int index = r.nextInt(n - i) + i;
            nums[i] = nums[index];
            nums[index] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        Question384 a = new Question384(new int[]{1, 2, 3});
        int[] result = a.shuffle();
        for (int i : result) {
            System.out.println(i);
        }
    }
}
