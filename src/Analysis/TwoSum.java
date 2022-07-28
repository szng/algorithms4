package Analysis;

import java.awt.desktop.SystemSleepEvent;
import java.util.*;

/**
 * leetcode 1
 * 将判断和是否符合变为寻找一个数
 */
public class TwoSum {
    public static int[] solve(int[] nums, int target) {
        int n = nums.length;
        int[][] id = new int[n][2];
        for (int i = 0; i < n; i++) {
            id[i] = new int[]{i, nums[i]};
        }
        Arrays.sort(id, (a, b) -> a[1] - b[1]);
        int[] indexs = new int[n];
        for (int i = 0; i < n; i++) {
            indexs[i] = id[i][0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(nums, target - nums[i]);
            if (index < 0) {
                continue;
            }
            int a = indexs[index];
            int b = indexs[i];
            if (a!= b) {
                if (a > b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                return new int[]{a, b};
            }
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,2,7};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
