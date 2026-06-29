class Solution {
    Node root;
    String[] words;
    List<String> results;
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        root = new Node('.');
        this.words = words;
        results = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            buildTrie(word, i);
        }
        Node curr = root;
        for (int j = 0; j < board.length; j++) {
            for (int k = 0; k < board[j].length; k++) {
                backtrack(curr, j, k);
            }
        }
        return results;
    }
    private void backtrack(Node curr, int x, int y) {
        if (x < 0 || x >= board.length) {
            return;
        }
        if (y < 0 || y >= board[x].length) {
            return;
        }
        char c = board[x][y];
        if (c == '#') {
            return;
        }
        if (!curr.children.containsKey(c)) {
            return;
        }
        curr = curr.children.get(c);
        if (curr.isComplete == true) {
            String word = words[curr.index];
            results.add(word);
            curr.isComplete = false;
        }
        board[x][y] = '#';
        backtrack(curr, x-1, y);
        backtrack(curr, x, y-1);
        backtrack(curr, x+1, y);
        backtrack(curr, x, y+1);
        board[x][y] = c;
    }
    private void buildTrie(String word, int index) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                Node node = new Node(c);
                curr.children.put(c, node);
                curr = node;
            }
            if (i == word.length()-1) {
                curr.isComplete = true;
                curr.index = index;
            }
        }
    }
    private class Node {
        Character character;
        Map<Character, Node> children;
        boolean isComplete = false;
        int index = -1;
        public Node(char c) {
            this.character = c;
            children = new HashMap<>();
        }
    }
}
