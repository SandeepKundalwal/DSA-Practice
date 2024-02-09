public class Main {
    public static void main(String[] args) {
        Node root = Node.generateTree(new Integer[]{10,10});
        System.out.println(isSumProperty(root));
    }

    public static int isSumProperty(Node root)
    {
        // add your code here
        return f(root) ? 1 : 0;
    }

    public static boolean f(Node root){
        if(root == null){
            return true;
        }

        if(!f(root.left) || !f(root.right)){
            return false;
        }

        if(root.left != null && root.right != null){
            return root.data == (root.left.data + root.right.data);
        } else if(root.left == null && root.right != null){
            return root.data == root.right.data;
        } else if(root.left != null && root.right == null) {
            return root.data == root.left.data;
        } else {
            return true;
        }
    }
}