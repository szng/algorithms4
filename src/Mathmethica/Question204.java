package Mathmethica;

import java.util.Arrays;

public class Question204 {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = n - 2;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        for (int i = 2; i < n; i++) {
            for (int j = 2 * i; j < n; j += i) {
                if (prime[j]) {
                    prime[j] = false;
                    --count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        Question204 a = new Question204();
        System.out.println(a.countPrimes(n));
    }
}
