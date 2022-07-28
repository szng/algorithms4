package DP;

public class Question376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][n + 1];
        int MaxCount = 0;
        dp[0][1] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 2; j >= 0; j--) {
                if (nums[i - 1] > nums[j]) {
                    dp[1][i] = Math.max(dp[1][i], dp[0][j + 1] + 1);
                }
            }
            for (int j = i - 2; j >= 0; j--) {
                if (nums[i - 1] < nums[j]) {
                    dp[0][i] = Math.max(dp[0][i], dp[1][j + 1] + 1);
                }
            }

        }
        for (int i = 1; i <= n; i++) {
            if (MaxCount < dp[0][i]) {
                MaxCount = dp[0][i];
            }
            if (MaxCount < dp[1][i]) {
                MaxCount = dp[1][i];
            }
        }
        return MaxCount;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3, 2, 5};
        Question376 a = new Question376();
        System.out.println(a.wiggleMaxLength(nums));
    }
}
