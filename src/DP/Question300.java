package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int MaxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > MaxLen) {
                MaxLen = dp[i];
            }
        }
        return MaxLen + 1;
    }

    //    贪心，保持每个长度的序列中最后一个数字最小的
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int MaxLen = 0;
        for (int i = 1; i < n; i++) {
            if (dp[MaxLen] < nums[i]) {
                dp[++MaxLen] = nums[i];
            } else {
                int index = Arrays.binarySearch(dp, 0, MaxLen, nums[i]);
                index = -index - 1;
                if (index >= 0)
                    dp[index] = nums[i];
            }
        }
        return MaxLen + 1;
    }

    public static void main(String[] args) {
        int[] n = new int[]{0, 1, 0, 3, 2, 3};
        Question300 a = new Question300();
        System.out.println(a.lengthOfLIS2(n));
    }
}
