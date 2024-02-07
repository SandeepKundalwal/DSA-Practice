import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) {
        Node root = Node.generateTree(new Integer[]{1,2,3,null,null,4,6,null,5,null,null,7,null});
        int a = 2;
        int b = 6;
        System.out.println(findDist(root, a, b));
    }

    public static int findDist(Node root, int a, int b) {
        // Your code here
        Node LCA = findLCA(root, a, b);

        return findNode(LCA, a, 0) + findNode(LCA, b, 0);
    }

    public static int findNode(Node root, int node, int distance){
        if(root == null){
            return 0;
        }

        if(root.data == node){
            return distance;
        }

        int left = findNode(root.left, node, distance + 1);
        int right = findNode(root.right, node, distance + 1);

        return left + right;
    }

    public static Node findLCA(Node root, int a, int b){
        if(root == null || root.data == a || root.data == b){
            return root;
        }

        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);

        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }

        return root;
    }
}