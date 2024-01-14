public class Main {
    public static void main(String[] args) {
        Integer nodes[] = {1,4,5,4,4,null,5,4,null,4,null,null,null,4};
        TreeNode root = TreeNode.generateTree(nodes);
        System.out.println(longestUnivaluePath(root));
    }

    public static int longestUnivaluePath(TreeNode root) {
        return f(root);
    }

    public static int f(TreeNode root){
        if(root == null){
            return 0;
        }

        int bothHeight = h(root, root.left) + h(root, root.right);
        int leftHeight = f(root.left);
        int rightHeight = f(root.right);

        return Math.max(bothHeight, Math.max(leftHeight, rightHeight));
    }

    public static int h(TreeNode prev, TreeNode root){
        if(root == null){
            return 0;
        }

        return prev.val == root.val ? 1 + Math.max(h(root, root.left), h(root, root.right)) : 0;
    }
}