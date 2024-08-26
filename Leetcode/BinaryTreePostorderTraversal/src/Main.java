import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{1,null,2,3});
        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        f(root, postorder);
        return postorder;
    }

    public static void f(TreeNode root, List<Integer> postorder){
        if(root == null){
            return;
        }

        f(root.left, postorder);
        f(root.right, postorder);
        postorder.add(root.val);
    }
}