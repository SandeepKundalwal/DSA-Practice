import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int leftLeafSum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- != 0){
                TreeNode node = queue.remove();

                if(node.left != null){
                    if(node.left.left == null && node.left.right == null){
                        leftLeafSum += node.left.val;
                    }
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return leftLeafSum;
    }
}
