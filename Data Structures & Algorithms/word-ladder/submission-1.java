class Solution {
    Map<String, List<String>> map;
    String endWord;
    Set<String> visited;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        map = new HashMap<>();
        visited = new HashSet<>();
        this.endWord = endWord;
        for (String word : wordList) {
            List<String> list = buildPatterns(word);
            for (String pattern : list) {
                List<String> neighbors = map.getOrDefault(pattern, new ArrayList<>());
                neighbors.add(word);
                map.put(pattern, neighbors);
            }
        }
        int num = bfs(beginWord);
        return num;

    }
    private List<String> buildPatterns(String word) {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            output.add(word.substring(0, i)+"*"+word.substring(i+1, word.length()));
        }
        return output;
    }
    private int bfs(String word) {
        int dist = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(word);
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return dist;
                }
                visited.add(curr);
                List<String> patterns = buildPatterns(curr);
                for (String pattern : patterns) {
                    List<String> next = map.getOrDefault(pattern, new ArrayList<>());
                    for (String s : next) {
                        if (visited.contains(s)) {
                            continue;
                        }
                        queue.add(s);
                    }
                }
            }
        }
        return 0;
    }
}
