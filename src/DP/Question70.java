package DP;

public class Question70 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int first = 1, second = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        Question70 a = new Question70();
        System.out.println(a.climbStairs(n));
    }
}
