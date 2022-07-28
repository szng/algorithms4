package DP;

import java.util.Arrays;

public class Question343 {
    public int integerBreak(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
                dp[i] = Math.max(dp[i], j * (i - j + 1));
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        Question343 a = new Question343();
        System.out.println(a.integerBreak(n));
    }
}
