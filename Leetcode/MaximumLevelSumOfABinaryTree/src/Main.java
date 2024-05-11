import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{-100,-200,-300,-20,-5,-10,null});
        System.out.println(maxLevelSum(root));
    }

    public static int maxLevelSum(TreeNode root) {
        int level = 1;
        long maxLevelSum = Long.MIN_VALUE;
        int smallestLevel = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            long currLevelSum = 0;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.remove();

                currLevelSum += node.val;

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            if(currLevelSum > maxLevelSum){
                maxLevelSum = currLevelSum;
                smallestLevel = level;
            }

            level++;
        }

        return smallestLevel;
    }
}