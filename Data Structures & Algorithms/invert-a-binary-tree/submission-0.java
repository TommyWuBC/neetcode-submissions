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
    public TreeNode invertTree(TreeNode root) {
        inverse(root);
        return root;
    }
    private void inverse(TreeNode curr) {
        if (curr == null) {
            return;
        }
        TreeNode temp = curr.right;
        curr.right = curr.left;
        curr.left = temp;
        inverse(curr.left);
        inverse(curr.right);
    }
}
