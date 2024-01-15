public class Main {
    public static void main(String[] args) {
        Integer nodes[] = {1,2,3,4,5};
        TreeNode root = TreeNode.generateTree(nodes);
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int maxi[] = new int[1];
        f(root, maxi);
        return maxi[0];
    }

    public static int f(TreeNode root, int maxi[]){
        if(root == null){
            return 0;
        }

        int leftHeight = f(root.left, maxi);
        int rightHeight = f(root.right, maxi);

        maxi[0] = Math.max(maxi[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}