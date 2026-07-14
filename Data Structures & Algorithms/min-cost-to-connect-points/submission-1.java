class Solution {
    Map<int[], int[]> parents;
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.dist, y.dist));
        for (int i = 0; i < points.length -1; i++) {
            for (int j = i+1; j < points.length; j++) {
                pq.add(new Edge(points[i], points[j]));
            }
        }
        parents = new HashMap<>();
        for (int[] point : points) {
            parents.put(point, point);
        }
        List<Edge> edges = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (!union(e.a, e.b)) {
                continue;
            }
            edges.add(e);
            count += e.dist;
        }
        return count;

    }
    private int[] find(int[] node) {
        int[] parent = parents.get(node);
        if (!parent.equals(node)) {
            parents.put(node, find(parent));
        }
        return parents.get(node);
    }
    private boolean union(int[] a, int[] b) {
        int[] rootA = find(a);
        int[] rootB = find(b);
        if (rootA.equals(rootB)) {
            return false;
        }
        parents.put(rootA, rootB);
        return true;
    }
    private class Edge{
        int[] a;
        int[] b;
        int dist;
        public Edge(int[] a, int[] b) {
            this.a = a;
            this.b = b;
            dist = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
        }
    }
}
