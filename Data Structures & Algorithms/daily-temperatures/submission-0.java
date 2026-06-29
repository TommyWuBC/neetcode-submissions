class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]) {
                int index = deque.pollLast();
                result[index] = i-index;
            }
            deque.addLast(i);
        }
        return result;
    }
}
