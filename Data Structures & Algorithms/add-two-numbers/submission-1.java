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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode curr = new ListNode();
        ListNode head = curr;
        ListNode prev = new ListNode();
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            curr.val = sum;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l2.val + carry;
                l2 = l2.next;
            }
            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            curr.val = sum;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
        }
        if (carry != 0) {
            curr.val =1;
        } else {
            prev.next = null;
        }
        return head;
    }
}
