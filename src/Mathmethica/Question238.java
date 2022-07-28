package Mathmethica;

public class Question238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        int[] first = new int[n], last = new int[n];
        first[0] = nums[0];
        last[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            first[i] = nums[i] * first[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            last[i] = nums[i] * last[i + 1];
        }
        nums[0] = last[1];
        nums[n - 1] = first[n - 2];
        for (int i = 1; i < n - 1; i++) {
            nums[i] = first[i - 1] * last[i + 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0};
        Question238 a = new Question238();
        int[] result = a.productExceptSelf(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
