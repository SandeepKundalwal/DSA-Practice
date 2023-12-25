import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(cloneGraph(null));
    }

    public static Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> visited = new HashMap<>();
        Node copyNode = new Node(node.val);
        dfs(node, copyNode, visited);
        return copyNode;
    }

    public static void dfs(Node node, Node copyNode, Map<Integer, Node> visited){
        visited.put(copyNode.val, copyNode);

        for(Node neighbor : node.neighbors){
            if(!visited.containsKey(neighbor.val)){
                Node newNode = new Node(neighbor.val);
                copyNode.neighbors.add(newNode);
                dfs(neighbor, newNode, visited);
            } else {
                copyNode.neighbors.add(visited.get(neighbor.val));
            }
        }
    }
}