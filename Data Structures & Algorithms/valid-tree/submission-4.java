class Solution {
    int[] freq;
    Map<Integer, List<Integer>> map;
    Set<Integer> visiting;
    Set<Integer> visited;
    public boolean validTree(int n, int[][] edges) {
        freq = new int[n];
        map = new HashMap<>();
        visiting = new HashSet<>();
        visited = new HashSet<>();
        for (int[] entry : edges) {
            List<Integer> list = map.getOrDefault(entry[0], new ArrayList<>());
            list.add(entry[1]);
            map.put(entry[0], list);
            list = map.getOrDefault(entry[1], new ArrayList<>());
            list.add(entry[0]);
            map.put(entry[1], list);
            freq[entry[1]] +=1;
            freq[entry[0]] +=1;
        }
        
        return dfs(0, -1)  && visited.size() == n;
    }
    private boolean dfs(int node, int prev) {
        if (visited.contains(node)) {
            return true;
        }
        if (visiting.contains(node)) {
            return false;
        }
        visiting.add(node);
        boolean valid = true;
        List<Integer> list = map.getOrDefault(node, new ArrayList<>());
        if (list.size() > 0) {
            for (int n : list) {
                if (n == prev) {
                    continue;
                }
                valid = valid && dfs(n, node);
            }
        }
        visiting.remove(node);
        visited.add(node);
        return valid;
    }
}
