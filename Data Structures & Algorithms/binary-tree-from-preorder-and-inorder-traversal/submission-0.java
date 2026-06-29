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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        root = build(root, preorder, inorder, 0, inorder.length, 0);
        return root;
    }
    private TreeNode build(TreeNode curr, int[] preorder, int[] inorder, int inMin, int inMax, int preIndex) {
        if (preIndex >= preorder.length) {
            return null;
        }
        if (inMin>= inMax) {
            return null;
        }
        curr = new TreeNode(preorder[preIndex]);
        int inIndex = 0;
        for (int i = inMin; i< inMax; i++) {
            if (inorder[i] == curr.val) {
                inIndex = i;
                break;
            }
        }
        int preleft = 0;
        int leftSize = inIndex - inMin;
        if (leftSize > 0) {
            preleft = preIndex +1;
            curr.left = build(curr.left, preorder, inorder, inMin, inIndex, preleft);
        }
        int preright = 1+leftSize+preIndex;
        if (preright < preorder.length) {
            curr.right = build(curr.right, preorder, inorder, inIndex+1, inMax, preright);
        }
        return curr;
    }
}
