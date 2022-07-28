package Bit;

public class Question338 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        int n = 5;
        Question338 a = new Question338();
        int[] result = a.countBits(n);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
