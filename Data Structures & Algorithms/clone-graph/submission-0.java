/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map;
    Set<Node> explored;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        explored = new HashSet<>();
        return createNode(node);
    }
    private Node createNode(Node original) {
        if (explored.contains(original) || original == null) {
            return null;
        }
        Node node = new Node(original.val);
        map.put(original, node);
        explored.add(original);
        for (Node n : original.neighbors) {
            Node copy = map.getOrDefault(n, null);
            if (copy == null) {
                copy = createNode(n);
            }
            node.neighbors.add(copy);
        }
        return node;
    }
}