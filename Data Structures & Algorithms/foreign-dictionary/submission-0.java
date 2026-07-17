class Solution {
    Map<Character, Set<Character>> graph;
    Map<Character, Integer> indegree;
    public String foreignDictionary(String[] words) {
        graph = new HashMap<>();
        indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }
        for (int i = 0; i < words.length-1; i++) {
            if (!compAdjacent(words[i], words[i+1])) {
                return "";
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (Character key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.add(key);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            Set<Character> set = graph.get(curr);
            for (char character : set) {
                int degree = indegree.get(character)-1;
                indegree.put(character, degree);
                if (degree == 0) {
                    queue.add(character);
                }
            }
        }
        if (sb.length() != indegree.size()) {
            return "";
        }
        return sb.toString();
    }
    private boolean compAdjacent(String a, String b) {
        if (a.length() > b.length() && a.startsWith(b)) {
            return false;
        }
        int pointer = 0;
        while (pointer < Math.min(a.length(), b.length())) {
            if (a.charAt(pointer) == b.charAt(pointer)) {
                pointer++;
                continue;
            }
            char from = a.charAt(pointer);
            char to = b.charAt(pointer);
            if (graph.get(from).add(to)) {
                indegree.put(to, indegree.get(to) + 1);
            }
            break;
        }
        return true;
    }
}
