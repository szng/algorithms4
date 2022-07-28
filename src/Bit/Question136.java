package Bit;

/**
 * x^x=0
 */
public class Question136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        Question136 a = new Question136();
        System.out.println(a.singleNumber(nums));
    }
}
