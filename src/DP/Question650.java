package DP;

public class Question650 {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= Math.pow(n, 0.5); j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Question650 a = new Question650();
        System.out.println(a.minSteps(12));
    }
}
