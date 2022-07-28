package Search.Question;

import java.util.ArrayDeque;
import java.util.Queue;

public class Question934 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final int[] directions = {-1, 0, 1, 0, -1};
    Queue<Point> queue;

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        queue = new ArrayDeque<>();
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point top = queue.poll();
                if (top == null) {
                    return level;
                }
                for (int j = 0; j < 4; j++) {
                    int x = top.x + directions[j];
                    int y = top.y + directions[j + 1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != 2) {
                        if (grid[x][y] == 1) {
                            return level;
                        } else {
                            grid[x][y] = 2;
                            queue.offer(new Point(x, y));
                        }
                    }
                }
            }
            ++level;
        }
        return level;
    }

    private void dfs(int[][] grid, int x, int y) {
        grid[x][y] = 2;
        queue.add(new Point(x, y));
        for (int i = 0; i < 4; i++) {
            int newx = x + directions[i];
            int newy = y + directions[i + 1];
            if (newx >= 0 && newx < grid.length && newy >= 0 && newy < grid[0].length && grid[newx][newy] == 1) {
                dfs(grid, newx, newy);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        Question934 a = new Question934();
        System.out.println(a.shortestBridge(grid));
    }
}
