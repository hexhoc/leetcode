package top_interview_150.array_string;

/*
122. Best Time to Buy and Sell Stock II
Medium
 */
public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        var s = new BestTimeToBuyAndSellStock2();
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4})); // 7
        System.out.println(s.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(s.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (minPrice <= prices[i]) {
                totalProfit = totalProfit + (prices[i] - minPrice);
            }
            minPrice = prices[i];
        }
        return totalProfit;
    }
}
