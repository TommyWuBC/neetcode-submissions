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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    private boolean isValid(TreeNode curr, TreeNode min, TreeNode max) {
        if (curr == null) {
            return true;
        }
        if ((max == null || curr.val < max.val) && (min == null || curr.val > min.val)) {
            return isValid(curr.left, min, curr) && isValid(curr.right, curr, max);
        }
        return false;
    }
}
