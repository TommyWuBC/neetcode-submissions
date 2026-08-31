class Solution {
    int[][] dp;
    int target;
    int[] nums;
    int s;
    public int findTargetSumWays(int[] nums, int target) {
        s = 0;
        this.nums = nums;
        this.target = target;
        for (int num : nums) {
            s += num;
        }
        dp = new int[nums.length][2*s +1];
        for (int[] col : dp) {
            Arrays.fill(col, -1);
        }
        return backtrack(0, 0);
    }
    private int backtrack(int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        if (dp[index][sum+s] != -1) {
            return dp[index][sum+s];
        }
        int result = backtrack(index+1, sum+nums[index]) + backtrack(index+1, sum-nums[index]);
        dp[index][sum+s] = result;
        return result;
    }
}
