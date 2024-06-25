public class Main {
    static int cSum = 0;
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        TreeNode.print(bstToGst(root));
    }

    public static TreeNode bstToGst(TreeNode root) {
        f(root);
        return root;
    }

    public static void f(TreeNode root){
        if(root == null){
            return;
        }

        f(root.right);
        cSum += root.val;
        root.val = cSum;
        f(root.left);
    }
}