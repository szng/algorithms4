package Exam;
/*
zoom
 */
import java.util.Arrays;

public class Q4 {
    public static int test() {
        int a = 1;
        try {
            a = 2;
            return a;
        } catch (Exception e) {
            a = 3;
            return a;
        } finally {
            a = 4;
            System.out.print("nowcode+");
        }
    }

    public static void main(String[] args) {
        int d = test();
        System.out.println(d);
        String str = "Alpha. Beta. Gamma.";
        String regex = "\\.\\s*";
        String[] result = str.split((regex));
        System.out.println(Arrays.toString(result));
    }
}
