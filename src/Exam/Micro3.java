package Exam;

public class Micro3 {
    public int[][] edges;
    public int[] data;
    public int[] visited;
    public int solution(int[] A, int[] B) {
        // write your code in Java 11 (Java SE 11)
        int n = A.length + 1;
        edges = new int[n][n];
        data = new int[n];
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = 1;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            edges[A[i]][B[i]] = 1;
            edges[B[i]][A[i]] = 1;
        }
        dfs(0);
        int result = 0;
        for (int i = 1; i < n; i++) {
            result += Math.ceil(data[i] / 5.0);
        }
        return result;
    }

    public int dfs(int i) {
        for (int j = edges[i].length - 1; j >= 0; j--) {
            if (visited[j] != 1 && edges[i][j] != 0) {
                visited[j] = 1;
                data[i] += dfs(j);
            }
        }
        return data[i];
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 1, 3, 3, 3, 3};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7};
        Micro3 m = new Micro3();
        System.out.println(m.solution(a, b));
    }
}
