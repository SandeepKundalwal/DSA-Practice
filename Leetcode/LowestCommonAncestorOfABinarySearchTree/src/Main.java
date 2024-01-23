public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        TreeNode p = TreeNode.findNode(root, 2);
        TreeNode q = TreeNode.findNode(root, 8);
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return f(root, p, q);
    }

    public static TreeNode f(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }

        if((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)){
            return root;
        } else if((p.val < root.val && q.val < root.val)){
            return f(root.left, p, q);
        } else {
            return f(root.right, p, q);
        }
    }
}