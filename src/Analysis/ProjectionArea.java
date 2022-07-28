package Analysis;

/**
 * leetcode 883
 */
public class ProjectionArea {
    public static int solve(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int count = 0;

        for (int i = 0; i < x; i++) {
            int temp = grid[i][0];
            for (int j = 0; j < y; j++) {
                if (grid[i][j] != 0) {
                    count++;
                }
                if (temp < grid[i][j]) {
                    temp = grid[i][j];
                }
            }
            count += temp;
        }

        for (int j = 0; j < y; j++) {
            int temp = grid[0][j];
            for (int i = 0; i < x; i++) {
                if (temp < grid[i][j]) {
                    temp = grid[i][j];
                }
            }
            count += temp;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {3, 4}};// result = 17
        int result = solve(grid);
        System.out.println(result);
    }
}
