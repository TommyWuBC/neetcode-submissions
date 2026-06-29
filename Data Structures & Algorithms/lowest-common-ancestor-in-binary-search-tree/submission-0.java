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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lowest = new TreeNode();
        commonAncestor(root, p, q, lowest);
        return lowest;
    }
    private void commonAncestor(TreeNode curr, TreeNode p, TreeNode q, TreeNode lowest) {
        if (curr == null) {
            return;
        }
        if (isDescendant(curr, p) && isDescendant(curr, q)) {
            lowest.val = curr.val;
            commonAncestor(curr.left, p, q, lowest);
            commonAncestor(curr.right, p, q, lowest);
        }
    }
    private boolean isDescendant(TreeNode curr, TreeNode target) {
        if (curr == null && target == null) {
            return true;
        }
        if (curr == null) {
            return false;
        }
        if (curr.val == target.val) {
            return true;
        }
        return isDescendant(curr.left, target) || isDescendant(curr.right, target);
    }
}
