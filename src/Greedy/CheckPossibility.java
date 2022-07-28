package Greedy;

/**
 * leetcode 665
 * 尽量降低不满足降序的数
 */
public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        int N = nums.length;
        if (N <= 2) {
            return true;
        }
        int count = 1;
        for (int i = 0; i < N-1; ++i) {
            if (nums[i] > nums[i + 1]) {
                if (--count < 0) {
                    return false;
                }
                if (i - 1 < 0) {
                    nums[i] = nums[i + 1];
                } else if (nums[i + 1] >= nums[i - 1]) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1};
        CheckPossibility a = new CheckPossibility();
        System.out.println(a.checkPossibility(nums));
    }
}
