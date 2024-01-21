import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int leftChild[] = {1,-1,3,-1};
        int rightChild[] = {2,-1,-1,-1};
        System.out.println(validateBinaryTreeNodes(n, leftChild, rightChild));
    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if(root == -1){
            return false;
        }

        Set<Integer> seenNodes = new HashSet<>();
        seenNodes.add(root);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.remove();
                // System.out.println(node);

                int left = leftChild[node];
                int right = rightChild[node];

                if(left != -1){
                    if(seenNodes.contains(left)){
                        return false;
                    }
                    queue.offer(left);
                    seenNodes.add(left);
                }

                if(right != -1){
                    if(seenNodes.contains(right)){
                        return false;
                    }
                    queue.offer(right);
                    seenNodes.add(right);
                }
            }
        }
        return seenNodes.size() == n;
    }

    public static int findRoot(int n, int leftChild[], int rightChild[]){
        boolean seenNodes[] = new boolean[n];
        for(int i = 0; i < n; i++){
            int left = leftChild[i];
            int right = rightChild[i];
            if(left != -1){
                if(seenNodes[left]) return -1;
                seenNodes[left] = true;
            }

            if(right != -1){
                if(seenNodes[right]) return -1;
                seenNodes[right] = true;
            }
        }

        int root = -1;
        for(int i = 0; i < n; i++){
            if(root != -1 && seenNodes[i] == false){
                return -1;
            }

            if(seenNodes[i] == false){
                root = i;
            }
        }
        return root;
    }
}