package Others;

import java.util.ArrayList;
import java.util.List;

public class Question54 {
    private List<Integer> result;
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        result = new ArrayList<>();
        while (left <= right && top <= bottom) {
            visit(matrix, left, right, top, bottom);
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }

    private void visit(int[][] matrix, int left, int right, int top, int bottom) {
        for (int i = left; i <= right; i++) {
            result.add(matrix[top][i]);
        }
        for (int i = top + 1; i <= bottom; i++) {
            result.add(matrix[i][right]);
        }
        if (left < right && top < bottom) {
            for (int i = right - 1; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            for (int i = bottom - 1; i > top; i--) {
                result.add(matrix[i][left]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{6,7,9}};
        Question54 a = new Question54();
        System.out.println(a.spiralOrder(matrix));
    }
}
