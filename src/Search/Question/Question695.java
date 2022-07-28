package Search.Question;

import java.util.ArrayDeque;

public class Question695 {
    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final int[] directions = {-1, 0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = m == 0 ? 0 : grid[0].length, localArea, Area = 0;
        ArrayDeque<Point> stack = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    localArea = 0;
                    stack.push(new Point(i, j));
                    while (!stack.isEmpty()) {
                        Point top = stack.pop();
                        localArea++;
                        for (int k = 0; k < 4; k++) {
                            int x = top.x + directions[k];
                            int y = top.y + directions[k + 1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                                grid[x][y] =0;
                                stack.push(new Point(x, y));
                            }
                        }
                    }
                    Area = Math.max(Area, localArea);
                }
            }
        }
        return Area;
    }


//    深度优先搜索
    public int maxAreaOfIsland2(int[][] grid) {
        int m = grid.length, n = m == 0 ? 0 : grid[0].length, Area = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Area = Math.max(Area, dfs(grid, i, j));
                }
            }
        }
        return Area;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0|| x >= grid.length || y >=grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        int area = 1;
        for (int i = 0; i < 4; i++) {
            area += dfs(grid, x + directions[i], y + directions[i + 1]);
        }
        return area;
    }
}
