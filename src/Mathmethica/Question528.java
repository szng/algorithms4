package Mathmethica;

import java.util.Arrays;
import java.util.Random;

public class Question528 {
    private int[] sum;
    public Question528(int[] w) {
        int n = w.length;
        sum = new int[n];
        sum[0] = w[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        Random r = new Random();
        int num = r.nextInt(sum.length);
        int index = Arrays.binarySearch(sum, num);
        if (index >= 0) {
            return index;
        } else {
            return -index - 1;
        }
    }
}
