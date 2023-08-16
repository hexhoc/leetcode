package top_liked.easy;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

/*
121. Best Time to Buy and Sell Stock
#array find value
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        var s = new BestTimeToBuyAndSellStock();
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
