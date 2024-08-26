import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public static Node createTree(Integer nodes[]){
        if (nodes == null || nodes.length == 0) return null;

        Node root = new Node(nodes[0]); // Create the root node
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty()) {
            Node parent = queue.poll(); // Get the current parent node
            parent.children = new ArrayList<>();
            i++;

            // Add children for the current parent node
            while (i < nodes.length) {
                if(nodes[i] == null){
                    break;
                } else {
                    Node child = new Node(nodes[i]);
                    parent.children.add(child);
                    queue.add(child);
                    i++;
                }
            }
        }

        return root;
    }
};