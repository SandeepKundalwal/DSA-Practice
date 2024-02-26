public class Main {
    public static void main(String[] args) {
        TreeNode p = TreeNode.generateTree(new Integer[]{1,2,3});
        TreeNode q = TreeNode.generateTree(new Integer[]{1,2,3});
        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return f(p, q);
    }

    public static boolean f(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        } else if((p != null && q == null) || (p == null && q != null)){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        return f(p.left, q.left) && f(p.right, q.right);
    }
}