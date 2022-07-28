package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 210
 */
public class FindOrder {
    private int[] indegree;
    private List<List<Integer>> graph;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indegree = new int[numCourses];
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int n = prerequisites.length;
        for (int[] prerequisite : prerequisites) {
            ++indegree[prerequisite[0]];
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int e = queue.poll();
            result.add(e);
            for (Integer edge : graph.get(e)) {
                indegree[edge]--;
                if (indegree[edge] == 0) {
                    queue.offer(edge);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                return new int[0];
            }
        }
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
