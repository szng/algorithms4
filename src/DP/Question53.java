package DP;

import java.util.Arrays;

public class Question53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int MaxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
        }
        for (int i = 1; i <= n; i++) {
            if (MaxSum < dp[i]) {
                MaxSum = dp[i];
            }
        }
        return MaxSum;
    }

    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int dp = 0;
        int MaxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            if (MaxSum < dp) {
                MaxSum = dp;
            }
        }
        return MaxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, -1, 7, 8};
        Question53 a = new Question53();
        System.out.println(a.maxSubArray2(nums));
    }
}
