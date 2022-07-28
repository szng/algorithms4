package DP;

public class Question213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2]);
        }
        int temp = dp[n];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return Math.max(dp[n], temp);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        Question213 a = new Question213();
        System.out.println(a.rob(nums));
    }
}
