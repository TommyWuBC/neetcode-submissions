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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int[] pointers = new int[lists.length];
        boolean done = false;
        ListNode head = new ListNode();
        ListNode curr = head;
        ListNode prev = new ListNode();
        while (!done) {
            done = true;
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i<lists.length; i++) {
                if (lists[i] != null) {
                    done = false;
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        index = i;
                    }         
                }
            }
            if (done) {
                break;
            }
            lists[index] = lists[index].next;
            curr.val = min;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }
}
