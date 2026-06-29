class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            maxheap.add(nums[i]);
        }
        for (int j = 0; j<k-1; j++) {
            stack.push(maxheap.poll());
        }
        return maxheap.poll();
    }
}
