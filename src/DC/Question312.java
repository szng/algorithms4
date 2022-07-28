package DC;

import java.util.Arrays;

public class Question312 {
    public int[] val;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        val = new int[n + 2];
        val[0] = 1;
        val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    int temp = val[i] * val[k] * val[j];
                    temp += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], temp);
                }
            }
        }
        return dp[0][n + 1];

//        分治超时
//        return maxCoins(val, 0, n + 1);
    }

    public int maxCoins(int[] nums, int l, int r) {
        if (l >= r - 1) {
            return 0;
        }
        int MaxValue = 0;
        for (int i = l + 1; i < r; i++) {
            int temp = nums[l] * nums[i] * nums[r];
            temp += maxCoins(nums, l, i) + maxCoins(nums, i, r);
            MaxValue = Math.max(temp, MaxValue);
        }
        return MaxValue;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5};
        Question312 a = new Question312();
        System.out.println(a.maxCoins(nums));
    }
}
