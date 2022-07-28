package Sort.Question;

/**
 * leetcode 215
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        int l = 0, r = n - 1;
        while (l < r) {
            int index = quickSort(nums, l, r);
            if (index == k) {
                return nums[k];
            } else if (index < k) {
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
        return nums[l];
    }

    public int quickSort(int[] nums, int lo, int hi) {
        int first = lo;
        int last = hi;
        if (lo >= hi) {
            return lo;
        }
        int temp = nums[lo];
        while (true) {
            while (lo < last && nums[lo] <= temp) {
                ++lo;
            }
            while (hi > first && nums[hi] >= temp) {
                --hi;
            }
            if (lo < hi) {
                int x = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = x;
            } else {
                break;
            }
        }
        nums[first] = nums[hi];
        nums[hi] = temp;
        return hi;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        FindKthLargest a = new FindKthLargest();
        System.out.println(a.findKthLargest(nums, k));
    }
}
