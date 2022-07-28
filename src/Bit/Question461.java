package Bit;

public class Question461 {
    public int hammingDistance(int x, int y) {
        int b = x ^ y;
        int result = 0;
        while (b != 0) {
            result += b & 1;
            b >>= 1;
        }
        return result;
    }

    public int hammingDistance2(int x, int y) {
        int b = x ^ y;
        int result = 0;
        while (b != 0) {
            b = b & (b - 1);
            ++result;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 3, y = 1;
        Question461 a = new Question461();
        System.out.println(a.hammingDistance2(x, y));
    }
}
