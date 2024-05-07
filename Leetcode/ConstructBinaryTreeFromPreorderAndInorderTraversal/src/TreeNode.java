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

    public static void printPreorderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        System.out.printf(root.val + " ");
        printPreorderTraversal(root.left);
        printPreorderTraversal(root.right);
    }

    public static void printInorderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        printPreorderTraversal(root.left);
        System.out.printf(root.val + " ");
        printPreorderTraversal(root.right);
    }
}