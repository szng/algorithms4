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
                int index = Arrays.binarySearch(nums, j + 1, n, -nums[i] - nums[j]);
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

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int first = 0;
        for (; first < n; first++) {
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }
            int target = -nums[first];
            int second = first + 1;
            int third = n - 1;
            while (second < third) {
                if (second > first + 1 && nums[second - 1] == nums[second]) {
                    second++;
                    continue;
                }
                if (third < n - 1 && nums[third] == nums[third + 1]) {
                    third--;
                    continue;
                }
                if (nums[second] + nums[third] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                    second++;
                    third--;
                } else if (nums[second] + nums[third] > target) {
                    third--;
                } else {
                    second++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum ans = new ThreeSum();
        System.out.println(ans.threeSum2(nums));
    }
}
