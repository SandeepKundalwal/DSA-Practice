public class DFS {
    static int leftLeafSum = 0;
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root.left == null && root.right == null){
            return 0;
        }

        findLeftLeafSum(root, false);
        return leftLeafSum;
    }

    public static void findLeftLeafSum(TreeNode root, boolean isLeft){
        if(root == null){
            return;
        }

        if(isLeft && root.left == null && root.right == null){
            leftLeafSum += root.val;
        }

        findLeftLeafSum(root.left, true);
        findLeftLeafSum(root.right, false);
    }
}
