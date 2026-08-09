class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for (int n : nums) {
            target += n;
        }
        if (target % 2 != 0) {
            return false;
        }
        target /= 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int num : nums) {
            for (int sum = target; sum >= num; sum--) {
                if (dp[sum - num]) {
                    dp[sum] = true;
                }
            }
        }
        return dp[target];
    }
}
