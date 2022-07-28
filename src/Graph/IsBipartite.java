package Graph;


import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 785
 */
public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                queue.offer(i);
            }
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int vertex : graph[node]) {
                    if (color[vertex] == 0) {
                        color[vertex] = color[node] == 1 ? 2 : 1;
                        queue.offer(vertex);
                    } else if (color[vertex] == color[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
