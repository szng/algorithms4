package Analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 15
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < n - 1; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int index = Arrays.binarySearch(nums, j + 1, n, 0 - nums[i] - nums[j]);
                if (index >= 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[index]);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        ThreeSum ans = new ThreeSum();
        System.out.println(ans.threeSum(nums));
    }
}
