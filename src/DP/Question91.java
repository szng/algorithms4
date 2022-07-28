package DP;

public class Question91 {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int pre = s.charAt(0) - '0';
        if (pre == 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        int cur;
        for (int i = 2; i <= n; i++) {
            cur = s.charAt(i-1) - '0';
            if ((pre < 1 || pre > 2) && cur == 0) {
                return 0;
            }
            if (pre == 1 || (pre == 2 && cur < 7)) {
                if (cur != 0) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
            }
            pre = cur;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "1001";
        Question91 a = new Question91();
        System.out.println(a.numDecodings(s));
    }
}
