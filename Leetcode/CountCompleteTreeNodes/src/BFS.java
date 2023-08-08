import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int cnt = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            cnt += size;
            while(size-- > 0){
                TreeNode node = queue.remove();

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }

        return cnt;
    }
}
