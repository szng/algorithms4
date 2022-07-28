package DP;

import java.util.Arrays;

/**
 * 两次动态规划，一次从左上开始，一次从右下开始
 */
public class Question542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
//           注意溢出问题，需要在循环中加一进行比较
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                    }
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);
                    }
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i < m - 1) {
                        dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j]);
                    }
                    if (j < n - 1) {
                        dp[i][j] = Math.min(dp[i][j + 1] + 1, dp[i][j]);
                    }
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        Question542 a = new Question542();
        int[][] result = a.updateMatrix(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }
}
