package Sort.Question;

import java.util.Arrays;

/**
 * leetcode 1498
 * 双指针，固定左端点
 */
public class NumSubseq {
    int MAX_N = 100005;
    int P = 1000000007;
    int[] f = new int[MAX_N];
    public void pretreatment() {
        f[0] = 1;
        for (int i = 1; i < MAX_N; ++i) {
            f[i] = (f[i - 1] << 1) % P;
        }
    }

    public int numSubseq(int[] nums, int target) {
        pretreatment();
        Arrays.sort(nums);
        int count = 0;
        int i = 0, N = nums.length;
        int j = N - 1;
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                count = (count + f[j - i]) % P;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14};
        NumSubseq a = new NumSubseq();
        System.out.println(a.numSubseq(nums, 22));
    }
}
