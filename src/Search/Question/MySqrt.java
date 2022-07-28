package Search.Question;

/**
 * leetcode 69
 */
public class MySqrt {
    public int mySqrt(int x) {
        long y = x;
        while (y * y > x) {
//            y = y / 2 + x / (2 * y);   //会有误差
            y = (y + x / y) / 2;
        }
        return (int) y;
    }

    public static void main(String[] args) {
        int x = 4;
        MySqrt a = new MySqrt();
        System.out.println(a.mySqrt(x));
    }
}
