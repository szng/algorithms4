package Union;

/*
leetcode 868
 */
public class BinaryGap {
    public int solution(int n) {
        int farest = 0;
        int bit;
        int LatterBit = 0;
        int FormerBit = 0;
        int i = 0;
        int temp;
        for (; i < 32; i++) {
            bit = n % 2;
            n >>= 1;
            if (bit == 1) {
                LatterBit = i;
                break;
            }
        }
        for (i++; i < 32; i++) {
            bit = n % 2;
            n >>= 1;
            if (bit == 1) {
                FormerBit = i;
                temp = FormerBit - LatterBit;
                if (temp > farest) {
                    farest = temp;
                }
                LatterBit = i;
            }
        }
        return farest;
    }

    public static void main(String[] args) {
        BinaryGap a = new BinaryGap();
        System.out.println(a.solution(8));
    }
}
