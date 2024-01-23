public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        return f(root);
    }

    public static int f(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + Math.max(f(root.left), f(root.right));
    }
}