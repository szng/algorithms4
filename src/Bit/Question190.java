package Bit;

public class Question190 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += n & 1;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 0b11111111111111111111111111111101;
        Question190 a = new Question190();
        System.out.println(Integer.toBinaryString(a.reverseBits(n)));
    }
}
