/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        set.add(curr);
        while (curr.next != null) {
            curr = curr.next;
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
        }
        return false;
    }
}
