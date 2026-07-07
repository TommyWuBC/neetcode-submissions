class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> visiting;
    Set<Integer> visited;
    public int countComponents(int n, int[][] edges) {
        map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            map.put(edge[1], list);
        }
        visiting = new HashSet<>();
        visited = new HashSet<>();
        int count = 0;
        for (int node=0; node < n; node++) {
            if (!visited.contains(node)) {
                count++;
                dfs(node);
            }
        }
        return count;
    }

    private void dfs(int node) {
        if (visited.contains(node) || visiting.contains(node)) {
            return;
        }
        visiting.add(node);
        List<Integer> list = map.getOrDefault(node, new ArrayList<>());
        if (list.size() > 0) {
            for (int n : list) {
                dfs(n);
            }
        }
        visiting.remove(node);
        visited.add(node);
        return;
    }
}
