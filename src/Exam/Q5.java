package Exam;
/*
zoom 第一题
 */
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] color = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        String colors = scanner.nextLine();
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == 'R') {
                color[i + 1] = 1;
            } else {
                color[i + 1] = -1;
            }
        }
        int[][] adj = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            scanner.nextLine();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> weight = new ArrayDeque<>();
        weight.offer(color[1]);
        int sum = 0;
        queue.offer(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int pre = weight.poll();
            sum += Math.abs(pre);
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && adj[node][i] == 1) {
                    queue.offer(i);
                    weight.offer(pre + color[i]);
                    visited[i] = true;
                }
            }
        }
        System.out.println(sum);
    }
}