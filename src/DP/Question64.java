package DP;

public class Question64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
//        dp[0] = 0;
//        注意判断条件顺序，先左边第一列，再第一行，可以少写判断条件
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] gird = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Question64 a = new Question64();
        System.out.println(a.minPathSum(gird));
    }
}
