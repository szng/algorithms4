package Bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.XMLFormatter;

public class Question260 {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return nums;
        }
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        ans = Integer.MIN_VALUE == ans ? ans : ans & (-ans);
        int set1 = 0, set2 = 0;
        for (int num : nums) {
            if ((num & ans) == 0) {
                set1 ^= num;
            } else {
                set2 ^= num;
            }
        }
        return new int[]{set1, set2};
    }

    public int[] singleNumber2(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return nums;
        }
        Map<Integer, Integer> data = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            data.put(num, data.getOrDefault(num, 0) + 1);
        }
        for (Integer i : data.keySet()) {
            if (data.get(i) == 1) {
                result.add(i);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        Question260 a = new Question260();
        int[] result = a.singleNumber(nums);
        for (int r : result) {
            System.out.println(r);
        }
    }
}
