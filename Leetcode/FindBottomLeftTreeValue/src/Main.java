import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{1,2,3});
        System.out.println(findBottomLeftValue(root));
    }

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int leftMostValue = root.val;
        while(!queue.isEmpty()){
            int size = queue.size();
            leftMostValue = queue.peek().val;
            for(int i = 0; i < size; i++){
                TreeNode treeNode = queue.remove();

                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }

                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }
        }
        return leftMostValue;
    }
}