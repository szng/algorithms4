package Exam;

public class Q1 {
    public int solution(int[] nums) {
        int n = nums.length;
        int negative = 0;
        int postive = 0;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] < 0) {
                negative++;
            } else {
                postive++;
            }
        }
        int result = zero + negative;
        int MIN = result;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                result -= 1;
                MIN = Math.min(result, MIN);
            } else if (nums[i] > 0) {
                result += 1;
                MIN = Math.min(result, MIN);
            }
        }
        return MIN;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, -1, 1, 1, - 1};
        Q1 a = new Q1();
        System.out.println(a.solution(nums));
    }
}
