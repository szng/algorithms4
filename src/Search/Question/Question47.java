package Search.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question47 {
    private List<List<Integer>> results;
    private List<Integer> result;
    private int n;
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        results = new ArrayList<>();
        result = new ArrayList<>();
        n = nums.length;
        visited = new boolean[n];
        if (n == 0) {
            return results;
        }
        Arrays.sort(nums);
        backtracking(nums, 0);
        return results;
    }

    private void backtracking(int[] nums, int level) {
        if (n == level) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            result.add(nums[i]);
            visited[i] = true;
            backtracking(nums, level + 1);
            result.remove(level);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2};
        Question47 a = new Question47();
        List<List<Integer>> results = a.permuteUnique(nums);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
