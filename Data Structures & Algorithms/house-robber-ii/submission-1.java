class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2)  {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp1 = new int[nums.length-1];
        int[] dp2 = new int[nums.length-1];
        dp1[0] = nums[0];
        dp1[1] = nums[1];
        dp2[0] = nums[1];
        dp2[1] = nums[2];
        for (int i = 0; i < nums.length-2;  i++) {
            if (i+2 < dp1.length && dp1[i] + nums[i+2] > dp1[i+2]) {
                dp1[i+2] = dp1[i] + nums[i+2];
            }
            if (i+3 < dp1.length && dp1[i] + nums[i+3] > dp1[i+3]) {
                dp1[i+3] = dp1[i] + nums[i+3];
            }
            if (i+3 < nums.length && dp2[i] + nums[i+3] > dp2[i+2]) {
                dp2[i+2] = dp2[i] + nums[i+3];
            }
            if (i+4 < nums.length && dp2[i] +  nums[i+4] > dp2[i+3]) {
                dp2[i+3] = dp2[i] + nums[i+4];
            }
        }
        return Math.max(Math.max(dp1[dp1.length-1], dp1[dp1.length-2]), Math.max(dp2[dp2.length-1], dp2[dp2.length-2]));
    }
}
