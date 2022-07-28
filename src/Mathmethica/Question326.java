package Mathmethica;

public class Question326 {
    public boolean isPowerOfThree(int n) {
        return ((Math.log10(n) / Math.log10(3)) % 1) == 0;
    }

    public static void main(String[] args) {
        int n = 243;
        Question326 a = new Question326();
        System.out.println(a.isPowerOfThree(n));
    }
}
