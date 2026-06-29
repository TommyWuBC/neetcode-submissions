class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> Integer.compare(a[0]*a[0] + a[1]*a[1], b[0]*b[0] + b[1]*b[1]));
        for (int[] y : points) {
            minheap.add(y);
        }
        int[][] output = new int[k][2];
        for (int i = 0; i< k; i++) {
            output[i] = minheap.poll();
        }
        return output;
    }
}
