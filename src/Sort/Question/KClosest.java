package Sort.Question;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 973
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        int N = points.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dis1 = o1[0] * o1[0] + o1[1] * o1[1];
                int dis2 = o2[0] * o2[0] + o2[1] * o2[1];
                return dis1 - dis2;
            }
        });
        for (int i = 0; i < N; i++) {
            queue.offer(points[i]);
        }
        int[][] result = new int[k][];
        for (; k > 0; k--) {
            result[k-1] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        KClosest a = new KClosest();
        int[][] result = a.kClosest(points, 2);
        for (int[] i : result) {
            for (int j : i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
