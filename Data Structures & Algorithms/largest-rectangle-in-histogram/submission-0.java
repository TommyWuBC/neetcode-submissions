class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxArea = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < heights[stack.peek()]) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int index = stack.pop();
                    int width;
                    if (stack.isEmpty()) {
                        width = i;
                    } else {
                        width = i - stack.peek() - 1;
                    }
                    int area = heights[index] * width;
                    maxArea = Math.max(maxArea, area);
                }
            } 
            stack.push(i);
        }
        int i = heights.length;
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int width;
            if (stack.isEmpty()) {
                width = i;
            } else {
                width = i - stack.peek() - 1;
            }
            int area = heights[index] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
