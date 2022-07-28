package Search.Question;

/**
 * leetcode 81
 */
public class Question81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid]) {
                ++l;
                continue;
            }
            if (nums[l] < nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }else{
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1, 1};
        int target = 0;
        Question81 a = new Question81();
        System.out.println(a.search(nums, 0));
    }
}
