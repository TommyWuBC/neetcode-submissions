class KthLargest {
    PriorityQueue<Integer> maxheap;
    int k;
    public KthLargest(int k, int[] nums) {
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxheap.add(num);
        }
        this.k = k;
    }
    
    public int add(int val) {
        maxheap.add(val);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <k-1; i++) {
            stack.push(maxheap.poll());
        }
        int kth = maxheap.peek();
        while (!stack.isEmpty()) {
            maxheap.add(stack.pop());
        }
        return kth;
    }
}
