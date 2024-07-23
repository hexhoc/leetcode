package problems.arrays;

import static util.Assertions.assertEquals;

/*
121. Best Time to Buy and Sell Stock
Easy
 */
public class _121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        var s = new _121_BestTimeToBuyAndSellStock();
        assertEquals(2, s.execute(new int[]{2,4,1,2}));
        assertEquals(5, s.execute(new int[]{7,1,5,3,6,4}));
        assertEquals(0, s.execute(new int[]{7,6,4,3,1}));
    }

    public int execute(int[] prices) {
        int minPrice = prices[0];
        int diff = 0;
        for (int currentPrice : prices) {
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }
            if (diff < currentPrice - minPrice) {
                diff = currentPrice - minPrice;
            }
        }

        return diff;
    }
}
