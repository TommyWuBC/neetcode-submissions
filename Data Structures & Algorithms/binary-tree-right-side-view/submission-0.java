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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Boolean> blocked = new HashMap<>();
        if (root == null) {
            return list;
        }
        blocked.put(0, true);
        TreeNode level = new TreeNode(1);
        list.add(root.val);
        levelView(root.right, blocked, level, list);
        levelView(root.left, blocked,  level, list);
        return list;
    }
    private void levelView(TreeNode curr, Map<Integer, Boolean> blocked, TreeNode level, List<Integer> list) {
        if (curr == null) {
            return;
        }
        if (blocked.getOrDefault(level.val, false) == false) {
            list.add(curr.val);
            blocked.put(level.val, true);
        }
        TreeNode next = new TreeNode(level.val +1);
        levelView(curr.right, blocked, next, list);
        levelView(curr.left, blocked, next, list);
    }
}
