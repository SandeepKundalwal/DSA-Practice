import com.sun.source.tree.Tree;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{3,4,5,1,2});
        TreeNode subRoot = TreeNode.generateTree(new Integer[]{4,1,2});
        System.out.println(isSubtree(root, subRoot));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean ans[] = {false};
        f(root, subRoot, ans);
        return ans[0];
    }

    public static void f(TreeNode root, TreeNode subRoot, boolean ans[]) {
        if(root == null){
            return;
        }

        if(root.val == subRoot.val){
            ans[0] |= util(root, subRoot);

            if(ans[0]) return;
        }

        f(root.left, subRoot, ans);
        f(root.right, subRoot, ans);
    }

    public static boolean util(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }

        if((root != null && subRoot == null) || (root == null && subRoot != null)){
            return false;
        }

        if(root.val != subRoot.val){
            return false;
        }

        return util(root.left, subRoot.left) && util(root.right, subRoot.right);
    }
}