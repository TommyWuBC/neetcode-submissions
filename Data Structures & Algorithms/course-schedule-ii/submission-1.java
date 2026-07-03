class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> visiting;
    Set<Integer> visited;
    int[] freq;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        visiting = new HashSet<>();
        visited = new HashSet<>();
        freq = new int[numCourses];
        for (int[] entry : prerequisites) {
            List<Integer> list = map.getOrDefault(entry[1], new ArrayList<>());
            list.add(entry[0]);
            map.put(entry[1], list);
            freq[entry[0]] +=1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                queue.add(i);
            }
        }
        if (queue.isEmpty()) {
            return new int[0];
        }
        boolean valid = true;
        for (int j = 0; j < numCourses; j++) {
            valid = valid && dfs(j);
        }
        if (!valid) {
            return new int[0];
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index] = node;
            index++;
            List<Integer> neighbors = map.getOrDefault(node, new ArrayList<>());
            if (neighbors.size() == 0) {
                continue;
            }
            for (int n : neighbors) {
                freq[n] -= 1;
                if (freq[n] == 0) {
                    queue.add(n);
                }
            }
        }
        return order;
    }
    private boolean dfs(int course) {
        if (freq[course] == 0) {
            return true;
        }
        if (visited.contains(course)) {
            return true;
        }
        if (visiting.contains(course)) {
            return false;
        }
        List<Integer> neighbors = map.getOrDefault(course, new ArrayList<>());
        boolean valid = true;
        visiting.add(course);
        if (neighbors.size() > 0) {
            for (int n : neighbors) {
                valid = valid && dfs(n);
            }
        }
        visiting.remove(course);
        visited.add(course);
        return valid;
    }
}
