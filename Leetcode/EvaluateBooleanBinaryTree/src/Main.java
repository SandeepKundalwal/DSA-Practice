public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{2,1,3,null,null,0,1});
        System.out.println(evaluateTree(root));
    }

    public static boolean evaluateTree(TreeNode root) {
        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){
            return root.val == 0 ? false : true;
        }

        return root.val == 2 ? evaluateTree(root.left) || evaluateTree(root.right) :
                evaluateTree(root.left) && evaluateTree(root.right);
    }
}