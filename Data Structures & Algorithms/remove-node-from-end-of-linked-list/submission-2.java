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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode nth = head;
        ListNode last = head;
        ListNode prev = null;
        for (int i = 0; i < n-1; i++) {
            last = last.next;
        }
        while (last.next != null) {
            prev = nth;
            last= last.next;
            nth = nth.next;
        }
        if (prev != null) {
            prev.next = nth.next;
        }
        if (nth.equals(head)) {
            return head.next;
        }
        return head;
    }
}
