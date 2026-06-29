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
    public int maxPathSum(TreeNode root) {
        TreeNode max = new TreeNode(Integer.MIN_VALUE);
        dfs(root, max);
        return max.val;
    }
    private int dfs(TreeNode curr, TreeNode max) {
        if (curr == null) {
            return 0;
        }
        int left = Math.max(0, dfs(curr.left, max));
        int right = Math.max(0, dfs(curr.right, max));
        int count = curr.val + left + right;
        if (count > max.val) {
            max.val = count;
        }
        return curr.val + Math.max(left, right);
    }
        
    
}
