package DP;

public class Question10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 2; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                    dp[i][j] = dp[i][j - 2];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i][j-2]; //dp[i][j-2]，考虑第一次匹配*，前面不用匹配了
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aaa", p = "ab*a*c*a";
        Question10 a = new Question10();
        System.out.println(a.isMatch(s, p));
    }
}
