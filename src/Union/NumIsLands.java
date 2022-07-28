package Union;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 200
 * 找出1的连通分量的个数
 */
public class NumIsLands {
    private Map<Integer, Integer> a;
    private int count;

    public int find(int e) {
        int temp = a.get(e);
        if (temp == e) {
            return e;
        }
        temp = find(temp);
        a.put(e, temp);
        return temp;
    }

    public boolean connect(int p, int q) {
        p = find(p);
        q = find(q);

        if (p != q) {
            a.put(p, q);
            --count;
        }

        return true;
    }

    public int solve(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        a = new HashMap<>();

        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    a.put(i * n + j, i * n + j);
                    ++count;
                }
            }
        }

        for (Integer key : a.keySet()) {
            i = key / n;
            j = key % n;

            if (i + 1 < m) {
                int bottom = n * (i + 1) + j;
                if (a.containsKey(bottom)) {
                    connect(key, bottom);
                }
            }
            if (j + 1 < n) {
                int right = n * i + j + 1;
                if (a.containsKey(right)) {
                    connect(key, right);
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        NumIsLands a = new NumIsLands();
        char[][] board = {{'1', '1', '1', '1', '0' }, {'1', '1', '0', '1', '0' }, {'1', '1', '0', '0', '0' }, {'0', '0', '0', '0', '0' }};
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
        }
        System.out.println(a.solve(board));

        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
        }
    }
}
