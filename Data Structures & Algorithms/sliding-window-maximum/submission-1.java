class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length -k +1];
        Deque<Integer> deque = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        int left = 0;
        int right = k-1;
        for (int j = 0; j < result.length; j++) {
            while (!deque.isEmpty() && deque.peekFirst() < left) {
                deque.pollFirst();
            }
            result[j] = nums[deque.peekFirst()];
            right++;
            while (!deque.isEmpty() && right < nums.length && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.addLast(right);
            left++;
        }
        return result;
    }
}
