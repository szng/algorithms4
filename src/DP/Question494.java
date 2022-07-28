package DP;

public class Question494 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int smallest = 0;
        int biggest = 0;
        for (int i = 0; i < n; i++) {
            smallest -= nums[i];
            biggest += nums[i];
        }
        if (target < smallest || target > biggest) {
            return 0;
        }

        int nega = biggest - target;
        if (nega % 2 != 0) {
            return 0;
        }
        nega = nega / 2;
        int[] dp = new int[nega + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = nega; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[nega];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        Question494 a = new Question494();
        System.out.println(a.findTargetSumWays(nums, 3));
    }
}
