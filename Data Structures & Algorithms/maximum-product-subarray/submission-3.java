class Solution {
    public int maxProduct(int[] nums) {
        int curr = 0;
        int sub = 1;
        int start = 0;
        int max = Integer.MIN_VALUE;
        int currMax = nums[0];
        int currMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int temp = currMax;
            currMax = Math.max(Math.max(val, currMax * val), currMin * val);
            currMin = Math.min(Math.min(val, temp * val), currMin * val);
            if (currMax > max) {
                max = currMax;
            }
        }
        return Math.max(max, currMax);
    }
}
