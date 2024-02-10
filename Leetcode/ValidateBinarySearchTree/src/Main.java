public class Main {
    static TreeNode previousNode;
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{5,1,4,null,null,3,6});
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        previousNode = null;
        return f(root);
    }

    public static boolean f(TreeNode root){
        if(root == null){
            return true;
        }

        boolean left = f(root.left);
        if(previousNode != null && previousNode.val >= root.val){
            return false;
        }
        previousNode = root;
        boolean right = f(root.right);

        return left && right;
    }
}