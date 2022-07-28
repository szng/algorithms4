package Search.Question;
/**
 * leetcode 417
 */

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
    private int[][] heights;
    private int[][] visited;
    private int[] directions = {-1, 0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = m == 0 ? 0 : heights[0].length;
        visited = new int[m][n];
        this.heights = heights;
        for (int i = 0; i < n; i++) {
            dfs(0, i, 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, 0, 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(m - 1, i, 2);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, 2);
        }

        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 3) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    results.add(temp);
                }
            }
        }
        return results;
    }

    private void dfs(int x, int y, int flag) {
        if (visited[x][y] >= flag) {
            return;
        }
        visited[x][y] += flag;
        for (int i = 0; i < 4; i++) {
            int newx = x + directions[i];
            int newy = y + directions[i + 1];
            if (newx >= 0 && newy >= 0 && newx < visited.length && newy < visited[0].length && heights[x][y] <= heights[newx][newy]) {
                dfs(newx, newy, flag);
            }
        }
    }
}
