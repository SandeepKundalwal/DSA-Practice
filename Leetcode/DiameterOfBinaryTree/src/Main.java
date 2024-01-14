public class Main {
    public static void main(String[] args) {
        Integer nodes[] = {1,2,3,4,5};
        TreeNode root = TreeNode.generateTree(nodes);
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        return f(root);
    }

    public static int f(TreeNode root){
        if(root == null){
            return 0;
        }

        int bothHeight = findHeight(root.left) + findHeight(root.right);
        int leftHeight = f(root.left);
        int rightHeight = f(root.right);

        return Math.max(bothHeight, Math.max(leftHeight, rightHeight));
    }

    public static int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}