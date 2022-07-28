package Search.Question;

/**
 * leetcode 154
 */
public class FindMin {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int mid;
        int min = nums[0];
        while (l <= r) {
            mid = l + (r - l) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[l] == nums[mid]) {
                ++l;
            } else if (nums[mid] <= nums[r]) {
                r = mid - 1;
            } else {
                min = Math.min(min, nums[l]);
                l = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        FindMin a = new FindMin();
        System.out.println(a.findMin(nums));
    }
}
