class Solution {
    Set<Integer> visiting;
    Set<Integer> visited;
    Map<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visiting = new HashSet<>();
        visited = new HashSet<>();
        map = new HashMap<>();
        for (int[] entry : prerequisites) {
            List<Integer> list = map.getOrDefault(entry[1], new ArrayList<>());
            list.add(entry[0]);
            map.put(entry[1], list);
        }
        boolean valid = true;
        for (int course = 0; course < numCourses; course++) {
            valid = valid && dfs(course);
        }
        return valid;
    }
    private boolean dfs(int course) {
        if (visited.contains(course)) {
            return true;
        }
        if (visiting.contains(course)) {
            return false;
        }
        visiting.add(course);
        List<Integer> neighbors = map.getOrDefault(course, new ArrayList<>());
        boolean valid = true;
        if (neighbors.size() >0) {
            for (int n : neighbors) {
                valid = valid && dfs(n);
            }
        }
        visiting.remove(course);
        visited.add(course);
        return valid;
    }
}
