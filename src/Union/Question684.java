package Union;

public class Question684 {
    class UF {
        private int[] id;
        private int[] size;

        public UF(int n) {
            id = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
        }

        public int root(int e) {
            while (e != id[e]) {
                id[e] = id[id[e]];
                e = id[e];
            }
            return e;
        }

        public boolean isConnected(int p, int q) {
            p = root(p);
            q = root(q);
            return p == q;
        }

        public void union(int p, int q) {
            p = root(p);
            q = root(q);
            if (size[p] < size[q]) {
                id[q] = p;
                size[p] += size[q];
            } else {
                id[p] = q;
                size[q] += size[p];
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UF Union = new UF(n + 1);
        for (int[] edge : edges) {
            if (Union.isConnected(edge[0], edge[1])) {
                return edge;
            }
            Union.union(edge[0], edge[1]);
        }
        return new int[0];
    }
}
