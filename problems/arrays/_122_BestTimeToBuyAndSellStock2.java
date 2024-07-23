package problems.arrays;

import static util.Assertions.assertEquals;

/*
122. Best Time to Buy and Sell Stock II
Medium
 */
public class _122_BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        var s = new _122_BestTimeToBuyAndSellStock2();
        assertEquals(3, s.execute(new int[]{2, 4, 1, 2}));
        assertEquals(7, s.execute(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, s.execute(new int[]{7, 6, 4, 3, 1}));
    }

    public int execute(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit = maxProfit + (prices[i] - prices[i - 1]);
            }
        }

        return maxProfit;
    }
}