package Analysis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 167
 * 将判断和是否符合变为寻找一个数
 */
public class TwoSum2 {
    public static int[] solve(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(nums, target - nums[i]);
            if (index >= 0 && i != index) {
                if (i < index) {
                    return new int[]{i + 1, index + 1};
                }
                return new int[]{index + 1, i + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 9, 56, 90};
        int target = 8;
        int[] result = solve(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
