import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{1,2,3,null,5,null,4});
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> rightView = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            rightView.add(deque.peekLast().val);
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode treeNode = deque.poll();

                if(treeNode.left != null){
                    deque.offer(treeNode.left);
                }

                if(treeNode.right != null){
                    deque.offer(treeNode.right);
                }
            }
        }
        return rightView;
    }
}