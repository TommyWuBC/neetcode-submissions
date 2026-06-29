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
    public boolean isBalanced(TreeNode root) {
        return balance(root);
    }
    private boolean balance(TreeNode curr) {
        if (curr == null) {
            return true;
        }
        int comp = height(curr.left) - height(curr.right);
        if (comp <= 1 && comp >= -1) {
            return balance(curr.left) && balance(curr.right);
        }
        return false;
    }
    private int height(TreeNode curr) {
        if (curr == null) {
            return -1;
        }
        return Math.max(height(curr.left), height(curr.right))+1;
    }
}
