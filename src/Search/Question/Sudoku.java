package Search.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 37
 */
public class Sudoku {
    private boolean[][] row = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    row[i][digit] = true;
                    column[j][digit] = true;
                    block[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int x = spaces.get(pos)[0];
        int y = spaces.get(pos)[1];

        for (int i = 0; i < 9 && !valid; i++) {
            if (!row[x][i] && !column[y][i] && !block[x / 3][y / 3][i]) {
                board[x][y] = (char) (i + '0' + 1);
                row[x][i] = column[y][i] = block[x / 3][y / 3][i] = true;
                dfs(board, pos + 1);
                row[x][i] = column[y][i] = block[x / 3][y / 3][i] = false;
            }
        }
    }
}
