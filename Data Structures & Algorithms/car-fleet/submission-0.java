class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int[][] cars = new int[position.length][2];
        for (int i= 0; i < position.length; i++) {
            cars[i][0]= position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(a[0], b[0]));
        for (int j = cars.length-1; j >=0; j--) {
            double time = (double)(target - cars[j][0]) / cars[j][1];
            if (stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
            }
        }
        return stack.size();
    }
}
