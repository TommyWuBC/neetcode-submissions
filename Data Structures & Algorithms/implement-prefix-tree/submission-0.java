class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node('.');
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i< word.length(); i++) {
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
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
            if (i == word.length()-1 && !curr.isComplete) {
                return false;
            }
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
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
