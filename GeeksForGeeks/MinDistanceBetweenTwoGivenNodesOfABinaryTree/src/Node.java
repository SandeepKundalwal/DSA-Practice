import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
public class Node {
    int data;
    Node left;
    Node right;
    Node() {}
    Node(int val) { this.data = val; }
    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public static Node generateTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(nodes[0]);
        queue.offer(root);

        for (int i = 1; i < nodes.length; i += 2) {
            Node current = queue.poll();

            if (nodes[i] != null) {
                current.left = new Node(nodes[i]);
                queue.offer(current.left);
            }

            if (i + 1 < nodes.length && nodes[i + 1] != null) {
                current.right = new Node(nodes[i + 1]);
                queue.offer(current.right);
            }
        }

        return root;
    }
}