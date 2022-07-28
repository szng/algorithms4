package Search.Question;

import java.util.ArrayList;
import java.util.List;

public class Question51 {
    private List<List<String>> results;

    public List<List<String>> solveNQueens(int n) {
        boolean[] column = new boolean[n];
        boolean[] LeftDiag = new boolean[2 * n - 1];
        boolean[] RightDiag = new boolean[2 * n - 1];
        char[][] result = new char[n][n];
        results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = '.';
            }
        }

        backtracking(result, 0, column, LeftDiag, RightDiag);

        return results;
    }

    private void backtracking(char[][] result, int x, boolean[] column, boolean[] LeftDiag, boolean[] RightDiag) {
        int n = result.length;
        if (x == n) {
            ArrayList<String> list = new ArrayList<>();
            for (char[] chars : result) {
                list.add(new String(chars));
            }
            results.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (column[i] || LeftDiag[n - 1 + x - i] || RightDiag[x + i]) {
                continue;
            }
            result[x][i] = 'Q';
            column[i] = LeftDiag[n - 1 + x - i] = RightDiag[x + i] = true;

            backtracking(result, x + 1, column, LeftDiag, RightDiag);

            result[x][i] = '.';
            column[i] = LeftDiag[n - 1 + x - i] = RightDiag[x + i] = false;
        }
    }
}
