class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int localmax = 1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    int val = dp[j] +1;
                    if (val > localmax) {
                        localmax = val;
                    }
                }
            }
            dp[i] = localmax;
            if (localmax > max) {
                max = localmax;
            }
        }
        return max;
    }
}
