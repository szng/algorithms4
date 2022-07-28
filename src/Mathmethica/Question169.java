package Mathmethica;

public class Question169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cur = nums[0];
        int count = 0;
        for (int num : nums) {
            if (cur == num) {
                ++count;
            } else {
                if (--count < 0) {
                    cur = num;
                    count = 1;
                }
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        Question169 a = new Question169();
        System.out.println(a.majorityElement(nums));
    }
}
