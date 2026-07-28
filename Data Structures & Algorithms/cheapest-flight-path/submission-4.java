class Solution {
    PriorityQueue<int[]> pq;
    int[][] best;
    Map<Integer, Set<int[]>> graph;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        best = new int[n][k+2];
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[k+2];
            Arrays.fill(arr, Integer.MAX_VALUE);
            best[i] = arr;
            graph.put(i, new HashSet<>());
        }
        for (int[] entry : flights) {
            Set<int[]> set = graph.getOrDefault(entry[0], new HashSet<>());
            int[] node = new int[2];
            node[0] = entry[1];
            node[1] = entry[2];
            set.add(node);
            graph.put(entry[0], set);
        }
        int count = 0;
        pq.add(new int[] {src, 0,  0});
        best[src][0] = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int j = 0; j < size; j++) {
                int[] node = pq.poll();
                if (node[2] == k + 1) {
                    continue;
                }
                int distance = node[1];
                for (int[] key : graph.get(node[0])) {
                    int next = key[0];
                    if (best[next][node[2]+1] > distance + key[1]) {
                        best[next][node[2]+1] = distance + key[1];
                        pq.add(new int[] {next, distance + key[1], node[2]+1});
                    }
                }
            }
            count++;
        }
        int result = Integer.MAX_VALUE;
        for (int a = 0; a <= k + 1; a++) {
            result = Math.min(result, best[dst][a]);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
