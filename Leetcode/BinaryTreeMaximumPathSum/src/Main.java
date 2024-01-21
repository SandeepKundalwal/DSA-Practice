public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.generateTree(new Integer[]{-10,9,20,null,null,-15,7,30,15});
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        int maxi[] = {Integer.MIN_VALUE};
        f(root, maxi);
        return maxi[0];
    }

    public static int f(TreeNode root, int maxi[]){
        if(root == null){
            return 0;
        }

        int leftSide = f(root.left, maxi);
        int rightSide = f(root.right, maxi);

        maxi[0] = Math.max(maxi[0], root.val + leftSide + rightSide);

        return (Math.max(root.val + Math.max(leftSide, rightSide), 0));
    }
}