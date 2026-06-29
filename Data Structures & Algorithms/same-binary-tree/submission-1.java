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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(p);
        queue2.add(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int size1 = queue1.size();
            int size2 = queue2.size();
            if (size1 != size2) {
                return false;
            }
            for (int i = 0; i < size1; i++) {
                TreeNode temp1 = queue1.poll();
                TreeNode temp2 = queue2.poll();
                if (temp1 == null && temp2 == null) {
                    continue;
                }
                if (temp1 == null || temp2 == null) {
                    return false;
                }
                if (temp1.val != temp2.val) {
                    return false;
                }
                queue1.add(temp1.left);
                queue1.add(temp1.right);
                queue2.add(temp2.left);
                queue2.add(temp2.right);
            }
        }
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}
