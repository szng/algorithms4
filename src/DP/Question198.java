package DP;


public class Question198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int first = nums[0];
        int pre = 0;
        int result = first;
        for (int i = 1; i < n; i++) {
            result = Math.max(first, nums[i] + pre);
            pre = first;
            first = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        Question198 a = new Question198();
        System.out.println(a.rob(nums));
    }
}
