package Mathmethica;

import java.util.Arrays;

public class Question462 {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int median = nums[n / 2];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(nums[i] - median);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 2, 9};
        Question462 a = new Question462();
        System.out.println(a.minMoves2(nums));
    }
}
