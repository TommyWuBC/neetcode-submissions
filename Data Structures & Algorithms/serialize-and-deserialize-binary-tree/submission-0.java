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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    private void preorder(TreeNode curr, StringBuilder sb) {
        if (curr == null) {
            sb.append("N,");
            return;
        }
        sb.append(curr.val).append(",");
        preorder(curr.left, sb);
        preorder(curr.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(queue);
    }
    private TreeNode build(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("N")) {
            return null;
        }
        TreeNode curr = new TreeNode(Integer.parseInt(s));
        curr.left = build(queue);
        curr.right = build(queue);
        return curr;
    }
}
