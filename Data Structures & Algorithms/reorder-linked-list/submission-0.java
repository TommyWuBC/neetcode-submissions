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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while (slow.next != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        slow.next = prev;
        ListNode curr = head;
        while (slow.next!= null && curr.next != null) {
            ListNode currnext = curr.next;
            ListNode slownext = slow.next;
            curr.next = slow;
            slow.next = currnext;
            slow = slownext;
            curr = currnext;
        }
    }
}
