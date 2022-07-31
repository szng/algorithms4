package Search.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question40 {
    private List<List<Integer>> results;
    private List<Integer> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        results = new ArrayList<>();
        result = new ArrayList<>();
        int n = candidates.length;
        if (n == 0) {
            return results;
        }
        Arrays.sort(candidates);
        backtracking(candidates, 0, target);
        return results;
    }

    private void backtracking(int[] candidates, int pos, int target) {
        if (target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
//            剪枝
            if (target < candidates[i]) {
                return;
            }
            if (i > pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            result.add(candidates[i]);
            backtracking(candidates, i + 1, target - candidates[i]);
            result.remove(result.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 5, 2, 1, 2};
        int target = 5;
        Question40 a = new Question40();
        List<List<Integer>> results = a.combinationSum2(candidates, target);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
