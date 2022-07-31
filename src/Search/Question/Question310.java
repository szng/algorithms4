package Search.Question;

/*
  拓扑排序
  构造邻接链表节省空间和时间
  最后的节点度数可能为0，但是一定会经过1再变成0
 */

import java.util.*;

public class Question310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] degree = new int[n];
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            if (count == n) {
                return new ArrayList<>(queue);
            }
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                for (Integer k : adjList[node]) {
                    degree[k]--;
                    if (degree[k] == 1) {
                        queue.offer(k);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};
        int n = 6;
        Question310 a = new Question310();
        List<Integer> result = a.findMinHeightTrees(n, edges);
        System.out.println(result);
    }
}
