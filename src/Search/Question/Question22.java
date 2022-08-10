package Search.Question;

import java.util.ArrayList;
import java.util.List;

public class Question22 {
    private List<String> results;
    private StringBuilder result;
    private int n;
    public List<String> generateParenthesis(int n) {
        results = new ArrayList<>();
        result = new StringBuilder();
        this.n = n;
        backtracking(0, 0);
        return results;
    }

    private void backtracking(int left, int right) {
        if (left == n && right == n) {
            results.add(result.toString());
            return;
        }
        if (left < n) {
            result.append("(");
            backtracking(left + 1, right);
            result.deleteCharAt(result.length()-1);
        }
        if (right < left) {
            result.append(")");
            backtracking(left, right + 1);
            result.deleteCharAt(result.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Question22 a = new Question22();
        List<String> strings = a.generateParenthesis(n);
        System.out.println(strings);
    }
}
