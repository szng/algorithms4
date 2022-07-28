package Search.Question;

public class Question79 {
    private boolean[][] visited;
    private boolean result;
    private final int[] directions = {-1, 0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtracking(board, i, j, word, 0);
            }
        }
        return result;
    }

    private void backtracking(char[][] board, int x, int y, String word, int pos) {
        if (pos == word.length()) {
            result = true;
            return;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        if (word.charAt(pos) != board[x][y]) {
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            backtracking(board, x + directions[i], y + directions[i + 1], word, pos + 1);
        }
        visited[x][y] = false;
    }
}
