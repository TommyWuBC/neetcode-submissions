class Solution {
    int[] parent;
    int[] skipped;
    public int[] findRedundantConnection(int[][] edges) {
        skipped = new int[2];
        parent = new int[edges.length+1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            boolean valid = union(a, b);
            if (!valid) {
                skipped = edge;
            }
        }
        return skipped;
        
    }
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        parent[rootA] = rootB;
        return true;
    }
}
