package Search.Question;

/**
 * leetcode 547
 * 找出连通分量的个数
 */
public class Friends {
    private int[][] friends;
    private int[] visited;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        if (n < 2) {
            return n;
        }
        visited = new int[n];
        friends = isConnected;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i);
                ++count;
            }
        }
        return count;
    }

    private void dfs(int index) {
        visited[index] = 1;
        for (int i = 0; i < friends[index].length; i++) {
            if (visited[i] == 0 && friends[index][i] == 1) {
                dfs(i);
            }
        }
    }
}
