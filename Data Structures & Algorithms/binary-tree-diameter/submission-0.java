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
    public int diameterOfBinaryTree(TreeNode root) {
        TreeNode max = new TreeNode(0);
        diameter(root, max);
        return max.val;
    }
    private void diameter(TreeNode curr, TreeNode max) {
        if (curr == null) {
            return;
        }
        int leftDia = depth(curr.left);
        int rightDia = depth(curr.right);
        if (leftDia + rightDia > max.val) {
            max.val = leftDia + rightDia;
        }
        diameter(curr.left, max);
        diameter(curr.right, max);
    }

    private int depth(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        return Math.max(depth(curr.left), depth(curr.right)) +1;
    }
}
