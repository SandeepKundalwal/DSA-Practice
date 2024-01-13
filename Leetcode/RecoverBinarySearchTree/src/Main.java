public class Main {
    private TreeNode prev;
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    public static void main(String[] args) {
        System.out.println("Need to make tree structure");
    }

    public void recoverTree(TreeNode root) {
        prev = first = middle = last = null;
        inorder(root);

        if(first != null && last != null){
            swap(first, last);
        } else if(first != null && middle != null){
            swap(first, middle);
        }
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);

        if(prev != null && root.val < prev.val){
            if(first == null){
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }

        prev = root;

        inorder(root.right);
    }

    public void swap(TreeNode node1, TreeNode node2){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}