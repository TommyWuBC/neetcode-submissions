/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Map<Node, Node> map = new HashMap<>();
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        Node copy = map.get(curr);
        head = copy;
        while (curr != null) {
            copy.next = map.getOrDefault(curr.next, null);
            copy.random = map.getOrDefault(curr.random, null);
            copy = copy.next;
            curr = curr.next;
        }
        return head;
    }
}
