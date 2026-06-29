class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node('.');
    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i <word.length(); i++) {
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
            }
        }
    }

    public boolean search(String word) {
        Node curr = root;
        return backtrack(word, 0, root);
    }
    private boolean backtrack(String word, int index, Node curr) {
        if (index == word.length()) {
            return curr.isComplete;
        }
        char c = word.charAt(index);
        if (c == '.') {
            boolean result = false;
            for (Node child: curr.children.values()) {
                result = result || backtrack(word, index+1, child);
            }
            return result;
        } else if (curr.children.containsKey(c)) {
            return backtrack(word, index+1, curr.children.get(c));
        } else {
            return false;
        }
    }
    private class Node {
        char character;
        Map<Character, Node> children;
        boolean isComplete = false;

        public Node(char c) {
            character = c;
            children = new HashMap<>();
        }
    }
}
