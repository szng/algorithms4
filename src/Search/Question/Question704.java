package Search.Question;

public class Question704 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
//        return l;
    }
}
