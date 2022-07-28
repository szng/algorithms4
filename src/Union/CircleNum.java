package Union;

/**
 * leetcode 547
 * 找出连通分量的个数
 */
public class CircleNum {
    private int[] id;
    private int[] size;
    private int count;

    public int root(int e) {
        if (e == id[e]) {
            return e;
        }
        id[e] = root(id[e]);
        return id[e];
    }

    public boolean connect(int p, int q) {
        p = root(p);
        q = root(q);
        if (size[p] < size[q]) {
            int temp = p;
            p = q;
            q = temp;
        }
        if (p != q) {
            id[q] = p;
            size[p] += size[q];
            --count;
        }

        return true;
    }

    public int solve(int[][] isConnected) {
        int n = isConnected.length;
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            ++count;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    connect(i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CircleNum a = new CircleNum();
        int[][] board = {{1,1,0 }, {1,1,0 }, {0,0,1}};
        for (int[] ints : board) {
            System.out.println();
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(ints[j]);
            }
        }
        System.out.println(a.solve(board));

        for (int[] ints : board) {
            System.out.println();
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(ints[j]);
            }
        }
    }
}
