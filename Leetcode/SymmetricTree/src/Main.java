public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{2,3,3,4,5,null,4});
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return f(root.left, root.right);
    }

    public static boolean f(TreeNode rootL, TreeNode rootR){
        if(rootL == null && rootR == null){
            return true;
        } else if(rootL == null && rootR != null){
            return false;
        } else if(rootL != null && rootR == null){
            return false;
        }

        if(rootL.val != rootR.val){
            return false;
        }

        boolean move1 = f(rootL.left, rootR.right);
        boolean move2 = f(rootL.right, rootR.left);

        return move1 && move2;
    }
}