package DoublePoint;

/**
 * leetcode 633
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        long l = 0, r = (long) Math.pow(c, 0.5);
        long result;
        while (l <= r) {
            result = l * l + r * r;
            if (result < c) {
                ++l;
            } else if (result > c) {
                --r;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int c = 2147483600;
        JudgeSquareSum a = new JudgeSquareSum();
        System.out.println(a.judgeSquareSum(c));
    }
}
