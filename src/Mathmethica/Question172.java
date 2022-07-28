package Mathmethica;

public class Question172 {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        return n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        int n = 5;
        Question172 a = new Question172();
        System.out.println(a.trailingZeroes(n));
    }
}
