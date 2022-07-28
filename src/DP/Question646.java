package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question646 {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n < 2) {
            return n;
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= -1; j--) {
                if (j == -1 || pairs[i - 1][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j + 1] + 1);
                    break;
                }
            }
        }
        return dp[n];
    }

    public int findLongestChain2(int[][] pairs) {
        int n = pairs.length;
        if (n < 2) {
            return n;
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= -1; j--) {
                if (j == -1 || pairs[i - 1][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j + 1] + 1);
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[][] pairs = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        Question646 a = new Question646();
        System.out.println(a.findLongestChain(pairs));
    }
}
