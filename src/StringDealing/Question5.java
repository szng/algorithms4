package StringDealing;

public class Question5 {
    private int count = 0;
    private String result;
    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            extendSubstring(s, i, i);
            extendSubstring(s, i, i + 1);
        }
        return result;
    }

    public void extendSubstring(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            int len = right - left + 1;
            if (count < len) {
                count = len;
                result = s.substring(left, right + 1);
            }
            --left;
            ++right;
        }
    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int begin = 0;
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n; i++) {
                int j = i + l - 1;
                if (j >= n) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, maxLen + begin);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        Question5 a = new Question5();
        System.out.println(a.longestPalindrome2(s));
    }
}
