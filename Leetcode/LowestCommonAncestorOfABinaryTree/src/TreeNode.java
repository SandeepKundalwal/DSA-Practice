import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode generateTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nodes[0]);
        queue.offer(root);

        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode current = queue.poll();

            if (nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.offer(current.left);
            }

            if (i + 1 < nodes.length && nodes[i + 1] != null) {
                current.right = new TreeNode(nodes[i + 1]);
                queue.offer(current.right);
            }
        }

        return root;
    }

    public static TreeNode findNode(TreeNode root, int node){
        if(root == null){
            return null;
        }

        if(root.val == node){
            return root;
        }

        TreeNode left = findNode(root.left, node);
        TreeNode right = findNode(root.right, node);

        if(left != null){
            return left;
        }

        if(right != null){
            return right;
        }

        return null;
    }
}