public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return 1 + f(root);
    }

    public static int f(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null){
            return 0;
        }

        return 1 + Math.min(f(root.left), f(root.right));
    }
}