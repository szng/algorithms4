package Exam;

import java.util.Arrays;

public class Micro {
    public int solution(int[] X, int[] Y, int W) {
        // write your code in Java 11 (Java SE 11)
        int n = X.length;
        if (n <= 1) {
            return 1;
        }
        Arrays.sort(X);
        int count = 1;
        int left = X[0] + W;
        for (int i = 1; i < n; i++) {
            if (left < X[i]) {
                count++;
                left = X[i] + W;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] x = new int[]{2, 4, 2, 6, 7, 1};
        int[] y = new int[]{0, 5, 3, 2, 1, 5};
        int w = 2;
        Micro a = new Micro();
        System.out.println(a.solution(x, y, 2));
    }
}
