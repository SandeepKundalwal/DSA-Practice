public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{1,2,3,2,null,2,4});
        int target = 2;
        TreeNode.printPreorderTraversal(removeLeafNodes(root, target));
    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        return f(root, target);
    }

    public static TreeNode f(TreeNode root, int target){
        if(root == null){
            return null;
        }

        root.left = f(root.left, target);
        root.right = f(root.right, target);

        if(root.left == null && root.right == null && root.val == target){
            return null;
        }

        return root;
    }
}