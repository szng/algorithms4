package DP;

public class Question121 {
    public int maxProfit(int[] prices) {
        int sell = 0, buy = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            sell = Math.max(sell, prices[i] - buy);
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Question121 a = new Question121();
        System.out.println(a.maxProfit(prices));
    }
}
