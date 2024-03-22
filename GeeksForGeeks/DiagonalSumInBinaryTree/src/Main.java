import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Node root = Node.generateTree(new Integer[]{10,20,30,10,15});
        System.out.println(diagonalSum(root));
    }

    public static ArrayList <Integer> diagonalSum(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            int sum = 0;
            for(int i = 0; i < size; i++){
                Node node = queue.remove();

                while(node != null){
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    sum += node.data;
                    node = node.right;
                }

            }
            ans.add(sum);
        }
        return ans;
    }
}