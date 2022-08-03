package Search.Question;

public class Question33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid = left + (right - left) / 2;
        while ((left <= right)) {
            if (target == nums[mid]) {
                return mid;
            }
            if ((nums[left] < nums[mid] && target >= nums[left] && target < nums[mid]) || (nums[mid] < nums[right] && (target < nums[mid] || target > nums[right]))) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 3};
        int target = 5;
        Question33 a = new Question33();
        System.out.println(a.search(nums, target));
    }
}
