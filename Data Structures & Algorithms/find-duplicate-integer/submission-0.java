class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        boolean met = false;
        while (!met) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                met = true;
            }
        }
        slow = 0;
        met = false;
        while (!met) {
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast) {
                met = true;
            }
        }
        return slow;
    }
}
