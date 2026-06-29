class MedianFinder {
    PriorityQueue<Integer> leftMaxheap;
    PriorityQueue<Integer> rightMinheap;
    int size;
    public MedianFinder() {
        leftMaxheap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        rightMinheap = new PriorityQueue<>();
        size = 0;
    }
    
    public void addNum(int num) {
        if (leftMaxheap.size() == 0 && rightMinheap.size() == 0) {
            leftMaxheap.add(num);
        } else if ((leftMaxheap.size() != 0 && num > leftMaxheap.peek()) || (rightMinheap.size() != 0 && num >= rightMinheap.peek())) {
            rightMinheap.add(num);
        } else {
            leftMaxheap.add(num);
        }
        size++;
        while ((size % 2 == 1 && leftMaxheap.size() > 1+size/2) || (size%2 == 0 && leftMaxheap.size() >size/2)) {
            rightMinheap.add(leftMaxheap.poll());
        }
        while ((size % 2 == 1 && rightMinheap.size() > 1+size/2) || (size%2 == 0 && rightMinheap.size() >size/2)) {
            leftMaxheap.add(rightMinheap.poll());
        }
    }
    
    public double findMedian() {
        if (leftMaxheap.size() == rightMinheap.size()) {
            return ((double)leftMaxheap.peek()+rightMinheap.peek())/2.0;
        } else if (leftMaxheap.size() > rightMinheap.size()) {
            return leftMaxheap.peek();
        } else {
            return rightMinheap.peek();
        }
    }
}
