package Sort.Question;

import java.util.Arrays;

/**
 * 剑指offer 51
 */
public class ReversePairs {
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
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                nums[k] = aux[j++];
                count += mid - i + 1;
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
        int[] nums = {1, 3, 7, 6};
        ReversePairs a = new ReversePairs();
        System.out.println(a.reversePairs(nums));
        for (int i : nums) {
            System.out.println(i);
        }
    }
}