public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{4,2,null,3,1});
        int val = 1;
        int depth = 3;
        TreeNode.print(addOneRow(root, val, depth));
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            return new TreeNode(val, root, null);
        }

        f(root, val, depth);

        return root;
    }

    public static void f(TreeNode root, int val, int depth){
        if(root == null){
            return;
        }

        if(depth == 2) {
            TreeNode newLeftNode = new TreeNode(val);
            TreeNode newRightNode = new TreeNode(val);

            newLeftNode.left = root.left;
            newRightNode.right = root.right;

            root.left = newLeftNode;
            root.right = newRightNode;

            return;
        }

        f(root.left, val, depth - 1);
        f(root.right, val, depth - 1);
    }
}