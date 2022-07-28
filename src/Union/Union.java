package Union;

public class Union {
    private static int[] id;
    private static int[] size;

    private static int root(int i) {
        while (i != id[i]) {
//           path compression: reduce the tree's height.
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public static boolean find(int p, int q) {
        p = root(p);
        q = root(q);
        return p == q;
    }

    public static void union(int p, int q) {
        p = root(p);
        q = root(q);
//        weighted: add the smaller tree to the bigger to reduce the tree's height.
//        if (size[p] > size[q]) {
//            id[q] = p;
//            size[p] += size[q];
//        } else {
//            id[p] = q;
//            size[q] += size[p];
//        }
        if (size[q] > size[p]) {
            int temp = p;
            p = q;
            q = temp;
        }
        id[q] = p;
        size[p] += size[q];
    }
}
