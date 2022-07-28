package DP;

/**
 * 以第i个结尾的子数组，再将所有个数加和
 * 到前一个距离和前一个到前两个距离相等，则表示为等差。
 * 因为根据上一步这个定义，相等是等价关系，距离都相等。
 * 所以后一个总数等于前一个加1。
 * 一部分是前一个的所有子数组再加上第i位，这时是等差。
 * 另一部分是最近的三个数，不包含在前一个结尾的子数组中
 */
public class Question413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int[] dp = new int[n];
        int result = 0;
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            result += dp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,8,9,10};
        Question413 a = new Question413();
        System.out.println(a.numberOfArithmeticSlices(nums));
    }
}
