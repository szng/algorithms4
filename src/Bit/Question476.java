package Bit;

public class Question476 {
    public int findComplement(int num) {
        int mask = 0xffffffff;
        int n = num;
        while (n > 0) {
            mask <<= 1;
            n >>= 1;
        }
        return (-num-1) & (-mask-1);
    }

    public static void main(String[] args) {
        int num = 1;
        Question476 a = new Question476();
        System.out.println(a.findComplement(num));
    }
}
