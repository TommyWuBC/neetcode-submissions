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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode maxLeft = new TreeNode(root.val);
        TreeNode maxRight = new TreeNode(root.val);
        TreeNode count = new TreeNode(1);
        findGood(root.left, maxLeft, count);
        findGood(root.right, maxRight, count);
        return count.val;
    }
    public void findGood(TreeNode curr, TreeNode max, TreeNode count) {
        if (curr == null) {
            return;
        }
        if (curr.val >= max.val) {
            count.val = count.val +1;
        }
        max.val = Math.max(max.val, curr.val);
        TreeNode maxLeft = new TreeNode(max.val);
        TreeNode maxRight = new TreeNode(max.val);
        findGood(curr.left, maxLeft, count);
        findGood(curr.right, maxRight, count);
    }
}
