package Bit;

public class Question693 {
    public boolean hasAlternatingBits(int n) {
        while (n > 0) {
            ;
            if (((n ^ (n >> 1)) & 1) == 0) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }

    public boolean hasAlternatingBits2(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 11;
        Question693 a = new Question693();
        System.out.println(a.hasAlternatingBits2(n));
    }
}
