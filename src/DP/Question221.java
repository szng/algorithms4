package DP;

/**
 * padding操作，补齐矩阵
 */
public class Question221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int MaxSide = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int temp = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    temp = Math.min(temp, dp[i][j - 1]);
                    dp[i][j] = temp + 1;
                    if (MaxSide < dp[i][j]) {
                        MaxSide = dp[i][j];
                    }
                }
            }
        }
        return MaxSide * MaxSide;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'0','1'},{'1','0'}};
        Question221 a = new Question221();
        System.out.println(a.maximalSquare(matrix));
    }
}
