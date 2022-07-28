package Search.Question;

/**
 * leetcode 540
 */
public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (mid % 2 == 0) {
                if (mid == 0) {
                    break;
                }
                if (nums[mid - 1] == nums[mid]) {
                    r = mid;
                } else if (nums[mid] == nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    return nums[mid];
                }
            } else if (nums[mid - 1] == nums[mid]) {
                l = mid + 1;
            } else if (nums[mid] == nums[mid + 1]) {
                r = mid;
            } else {
                return nums[mid];
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        SingleNonDuplicate a = new SingleNonDuplicate();
        System.out.println(a.singleNonDuplicate(nums));
    }
}
