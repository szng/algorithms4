package Union;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 130
 * 设置一个源节点，即为边界
 * 连接到边界的即为O
 */
public class SurroundRegion {
    private Map<Integer, Integer> a;

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
        if (p == 0) {
            a.put(q, 0);
        } else {
            a.put(p, q);
        }
        return true;
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int bank = 0;
        a = new HashMap<>();
        a.put(bank, bank);

        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    a.put(i * n + j + 1, i * n + j + 1);
                }
            }
        }

        for (Integer key : a.keySet()) {
            if (key == 0) {
                continue;
            }
            int temp = key - 1;
            i = temp / n;
            j = temp % n;
            if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                connect(key, bank);
            }

//            if (i - 1 >= 0) {
//                int top = n * (i - 1) + j + 1;
//                if (a.containsKey(top)) {
//                    connect(key, top);
//                }
//            }
            if (i + 1 < m) {
                int bottom = n * (i + 1) + j + 1;
                if (a.containsKey(bottom)) {
                    connect(key, bottom);
                }
            }
//            if (j - 1 >= 0) {
//                int left = n * i + j - 1 + 1;
//                if (a.containsKey(left)) {
//                    connect(key, left);
//                }
//            }
            if (j + 1 < n) {
                int right = n * i + j + 1 + 1;
                if (a.containsKey(right)) {
                    connect(key, right);
                }
            }

        }
        for (Integer key : a.keySet()) {
            if (find(key) != 0) {
                i = (key - 1) / n;
                j = (key - 1) % n;
                board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        SurroundRegion a = new SurroundRegion();
        char[][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}}
        ;
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
        }
        System.out.println();
        a.solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
        }
    }
}
