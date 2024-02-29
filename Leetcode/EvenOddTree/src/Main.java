import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{1,10,4,3,null,7,9,12,8,6,null,null,2});
        System.out.println(isEvenOddTree(root));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        if(root.val % 2 == 0) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean evenLevel = true;

        while(!queue.isEmpty()){
            int prev = evenLevel ? 0 : (int)1e6 + 1;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode treeNode = queue.remove();
                if(evenLevel){
                    if(treeNode.val % 2 == 0 || prev >= treeNode.val){
                        return false;
                    }
                } else {
                    if(treeNode.val % 2 == 1 || prev <= treeNode.val){
                        return false;
                    }
                }

                prev = treeNode.val;

                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }

                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }
            evenLevel = !evenLevel;
        }

        return true;
    }
}