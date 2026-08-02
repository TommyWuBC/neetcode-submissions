class Solution {
    int[] dp;
    int[] coins;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        this.coins = coins;
        dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            dp[i] = findmin(i);
        }
        if (dp[amount] == Integer.MAX_VALUE || dp[amount] == -Integer.MAX_VALUE || dp[amount] == -1) {
            return -1;
        }
        return dp[amount];
    }
    private int findmin(int val) {
        if (dp[val] != -1) {
            return dp[val];
        }
        for (int n : coins) {
            if (n == val) {
                return 1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (coin > val) {
                continue;
            }
            if (findmin(val-coin)== Integer.MAX_VALUE) {
                continue;
            }
            int num = 1 + findmin(val-coin);
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
