class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int minIndex =-1;
        int maxProfit = 0;
        int maxIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                int profit = prices[i] - min;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            } else if (prices[i] < min) {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
