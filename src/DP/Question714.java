package DP;

public class Question714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = -prices[0], sell = 0;
        for (int i = 0; i < n; i++) {
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, buy + prices[i] - fee);
        }
        return Math.max(buy, sell);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 7, 5, 10, 3};
        int fee = 3;
        Question714 a = new Question714();
        System.out.println(a.maxProfit(prices, fee));
    }
}
