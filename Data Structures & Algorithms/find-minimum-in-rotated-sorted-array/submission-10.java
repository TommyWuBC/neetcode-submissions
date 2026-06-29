class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = nums.length-1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int mid = (left+right)/2;
        while (left <= right) {
            mid = (left+right)/2;
            if (nums[(mid-1+n)%n] > nums[mid] && nums[(mid+1)%n] > nums[mid]) {
                return nums[mid];
            } else if (nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return nums[mid];
    }
}
