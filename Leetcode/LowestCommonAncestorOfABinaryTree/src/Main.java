import com.sun.source.tree.Tree;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p = TreeNode.findNode(root, 2);
        TreeNode q = TreeNode.findNode(root, 1);
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return f(root, p, q);
    }

    public static TreeNode f(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = f(root.left, p, q);
        TreeNode right = f(root.right, p, q);

        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }

        return root;
    }
}