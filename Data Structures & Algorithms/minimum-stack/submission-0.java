class MinStack {
    Deque<Integer> deque;
    Deque<Integer> min;

    public MinStack() {
        deque = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        deque.addLast(val);
        if (min.isEmpty()) {
            min.addLast(val);
        } else {
            min.addLast(Math.min(min.peekLast(), val));
        }
    }
    
    public void pop() {
        deque.pollLast();
        min.pollLast();
    }
    
    public int top() {
        return deque.peekLast();
    }
    
    public int getMin() {
        return min.peekLast();
    }
}
