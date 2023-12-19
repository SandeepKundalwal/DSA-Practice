public class Main {
    public static void main(String[] args) {
        System.out.println("Need to make the structure of Tree");
    }

    // Let's use Morris Traversal
    public static void flatten(TreeNode root) {
        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;

                while(prev.right != null){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                    curr = curr.right;
                }
            }
        }
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

