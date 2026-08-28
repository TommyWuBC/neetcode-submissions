class Solution {
    Integer[][] dp;
    int[] prices;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.dp = new Integer[prices.length][2];

        return dfs(0, true);
    }

    private int dfs(int i, boolean buying) {
        if (i >= prices.length) {
            return 0;
        }

        int state = buying ? 1 : 0;

        if (dp[i][state] != null) {
            return dp[i][state];
        }

        int profit;

        if (buying) {
            int buy = dfs(i + 1, false) - prices[i];
            int skip = dfs(i + 1, true);

            profit = Math.max(buy, skip);
        } else {
            int sell = dfs(i + 2, true) + prices[i];
            int skip = dfs(i + 1, false);

            profit = Math.max(sell, skip);
        }

        dp[i][state] = profit;
        return profit;
    }
}