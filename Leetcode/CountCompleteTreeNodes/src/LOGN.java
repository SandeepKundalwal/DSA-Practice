public class LOGN {
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

        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);

        if(leftHeight == rightHeight){
            return ((1 << leftHeight) - 1);
        }

        return 1 + (countThem(root.left) + countThem(root.right));
    }

    public static int findLeftHeight(TreeNode root){
        int leftHeight = 0;

        while(root != null){
            leftHeight++;
            root = root.left;
        }

        return leftHeight;
    }

    public static int findRightHeight(TreeNode root){
        int rightHeight = 0;

        while(root != null){
            rightHeight++;
            root = root.right;
        }

        return rightHeight;
    }
}
