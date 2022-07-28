package Search.Question;
/**
 * 原地数组递归，按位置，第一位选定，然后后面递归进行全排列
 */

import java.util.ArrayList;
import java.util.List;

public class Question46 {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int level, List<List<Integer>> result) {
        int n = nums.length;
        if (level == n - 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        for (int i = level; i < n; i++) {
            int temp = nums[i];
            nums[i] = nums[level];
            nums[level] = temp;

            backtrack(nums, level + 1, result);

//          要回改成原来的状态，否则上一位选择可能有错漏
            temp = nums[i];
            nums[i] = nums[level];
            nums[level] = temp;
        }
    }
}
