/**
 * leetcode 765
 * 不懂证明
 */
package Union;

public class SwapsCouples {
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

    public void union(int p, int q) {
        p = root(p);
        q = root(q);
        if (p == q) {
            return;
        }
        if (size[q] > size[p]) {
            int temp = p;
            p = q;
            q = temp;
        }
        id[q] = p;
        size[p] += size[q];
        --count;
    }

    public int solve(int[] row) {
        int n = row.length / 2;
        count = n;
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        for (int i = 0; i < n; i++) {
            union(row[2 * i] / 2, row[2 * i + 1] / 2);
        }
        return n - count;
    }

    public static void main(String[] args) {
        int[] row = {3,2,0,1};
        SwapsCouples result = new SwapsCouples();
        System.out.println(result.solve(row));
    }
}
