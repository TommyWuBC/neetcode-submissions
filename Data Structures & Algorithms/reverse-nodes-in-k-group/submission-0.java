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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode start = new ListNode();
        boolean firstk = false;
        ListNode newhead = new ListNode();
        ListNode prevtail = new ListNode();
        while (curr != null) {
            ListNode scout = curr;
            ListNode prev = null;
            for (int i = 0; i < k; i++) {
                if (scout == null) {
                    prevtail.next = curr;
                    return head;
                }
                scout = scout.next;
            }
            for (int i = 0; i < k; i++) {
                if (i == 0) {
                    start = curr;
                }
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                if (!firstk && i == k-1) {
                    head = prev;
                    firstk = true;
                } else if (i == k-1) {
                    newhead = prev;
                }
            }
            prevtail.next = newhead;
            start.next = curr;
            prevtail = start;
        }
        return head;
    }
}
