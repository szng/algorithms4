package Search.Question;

/**
 * leetcode 34
 * 注意区间开闭，整数除法特性，靠左，下取整
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int l = lowerBound(nums, target);
        int r = upperBound(nums, target) - 1;
        if (l >= nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r};
    }

    public int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int upperBound(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (target < nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        SearchRange a = new SearchRange();
        int[] result = a.searchRange(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
