package Sort.Question;

import java.util.Arrays;

/**
 * leetcode 493
 * 注意考虑负数，2倍数之后减少
 */
public class ReversePairs2 {
    public int reversePairs(int[] nums) {
        int[] aux = Arrays.copyOf(nums, nums.length);
        return reversePairs(nums, aux, 0, nums.length - 1);
    }

    public int merge(int[] nums, int[] aux, int lo, int hi) {
        int i = lo, count = 0;
        int mid = (lo + hi) / 2, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }

        int m = lo;
        int n = mid + 1;
        while (m <= mid) {
            while (n <= hi && (long) nums[m] > 2 * (long) nums[n]) {
                n++;
            }
            count += n - mid - 1;
            m++;
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                nums[k] = aux[j++];
            } else {

                nums[k] = aux[i++];
            }
        }
        return count;
    }

    public int reversePairs(int[] nums, int[] aux, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (hi <= lo) {
            return 0;
        }
        int lcount = reversePairs(nums, aux, lo, mid);
        int rcount = reversePairs(nums, aux, mid + 1, hi);
        int count = merge(nums, aux, lo, hi);
        return lcount + rcount + count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        ReversePairs2 a = new ReversePairs2();
        System.out.println(a.reversePairs(nums));
        for (int i : nums) {
            System.out.println(i);
        }
    }
}