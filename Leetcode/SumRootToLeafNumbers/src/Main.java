public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{1,2,3});
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        return f(0, root);
    }

    public static int f(int num, TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return num * 10 + root.val;
        }

        int leftSum = f(num * 10 + root.val, root.left);
        int rightSum = f(num * 10 + root.val, root.right);

        return leftSum + rightSum;
    }
}