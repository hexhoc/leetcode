package problems.arrays;

/*
121. Best Time to Buy and Sell Stock
Easy
 */
public class _121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        var s = new _121_BestTimeToBuyAndSellStock();
        System.out.println(s.maxProfit(new int[]{2,4,1,2}));
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(s.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int minPrice= prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                if (maxProfit < prices[i]-minPrice) {
                    maxProfit = prices[i]-minPrice;
                }
            } else {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
