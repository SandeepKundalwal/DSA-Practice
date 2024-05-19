public class Main {
    static int stepsRequired = 0;
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{0,5,1,0,2,2,0,0,1,0,0});
        System.out.println(distributeCoins(root));
    }

    public static int distributeCoins(TreeNode root) {
        f(root);
        return stepsRequired;
    }

    public static int f(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftRequired = f(root.left);
        int rightRequired = f(root.right);

        stepsRequired += (Math.abs(leftRequired) + Math.abs(rightRequired));

        return (root.val - 1) + leftRequired + rightRequired;
    }
}