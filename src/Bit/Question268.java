package Bit;

import java.util.HashMap;
import java.util.Map;

public class Question268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> data = new HashMap<>();
        for (int i : nums) {
            data.put(i, 1);
        }
        for (int i = 0; i < n; i++) {
            int temp = data.getOrDefault(i, 0);
            if (temp == 0) {
                return i;
            }
        }
        return 0;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return n * (n + 1) / 2 - sum;
    }

    public int missingNumber3(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result ^ nums[i] ^ (i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        Question268 a = new Question268();
        System.out.println(a.missingNumber3(nums));
    }
}
