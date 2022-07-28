package Greedy;

/**
 * leetcode 122
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (N < 2) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < N; ++i) {
            result += Math.max(0,prices[i]-prices[i-1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        MaxProfit a = new MaxProfit();
        System.out.println(a.maxProfit(prices));
    }
}
