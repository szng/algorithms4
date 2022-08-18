package Exam;

import java.util.Arrays;

public class Q11 {
    public int[] calculate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n <= 1) {
            return nums;
        }

        int end = n - 1, maxlength = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] - 1 == nums[i - 1]) {
                count++;
            }else{
                count = 1;
            }
            if (count > maxlength) {
                maxlength = count;
                end = i;
            }
        }
        return Arrays.copyOfRange(nums, end - maxlength + 1, end + 1);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0, 4, 200, 1, 3, 2};
//        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums = new int[]{0, 1};
        Q11 a = new Q11();
        System.out.println(Arrays.toString(a.calculate(nums)));
    }
}
