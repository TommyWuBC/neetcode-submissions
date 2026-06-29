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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return check(root, subRoot);
    }
    private boolean check(TreeNode curr, TreeNode subRoot) {
        if (same(curr, subRoot)) {
            return true;
        }
        if (curr == null) {
            return false;
        }
        return check(curr.left, subRoot) || check(curr.right, subRoot);
    }
    private boolean same(TreeNode curr, TreeNode subRoot) {
        if (curr == null && subRoot == null) {
            return true;
        }
        if (curr == null || subRoot == null) {
            return false;
        }
        TreeNode comp = subRoot;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(curr);
        queue2.add(comp);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int size1 = queue1.size();
            int size2 = queue2.size();
            if (size1 != size2)  {
                return false;
            }
            for (int i =0; i< size1; i++) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null || node2 == null) {
                    return false;
                }
                if (node1.val != node2.val) {
                    return false;
                }
                queue1.add(node1.left);
                queue1.add(node1.right);
                queue2.add(node2.left);
                queue2.add(node2.right);
            }
        }
        if (!queue1.isEmpty() || !queue2.isEmpty()) {
            return false;
        }
        return true;
    }
}
