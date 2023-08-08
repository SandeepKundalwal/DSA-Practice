public class DFS {
    public static int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        return countThem(root);
    }

    public static int countThem(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + (countThem(root.left) + countThem(root.right));
    }
}
