/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list, k);
        return list.get(k-1);
    }
    private void inOrder(TreeNode curr, List<Integer> list, int k) {
        if (curr == null) {
            return;
        }
        if (list.size() >= k) {
            return;
        }
        inOrder(curr.left, list, k);
        list.add(curr.val);
        inOrder(curr.right, list, k);
    }
}
