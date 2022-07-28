package DP;

import java.util.Arrays;

public class Question188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int sum = 0;
        if (k >= n) {
            for (int i = 1; i < n; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    sum += prices[i] - prices[i - 1];
                }
            }
            return sum;
        }
        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k];
    }

    public static void main(String[] args) {
        int k = 2;
        int[] prices = new int[]{2, 4, 1};
        Question188 a = new Question188();
        System.out.println(a.maxProfit(k, prices));
    }
}
