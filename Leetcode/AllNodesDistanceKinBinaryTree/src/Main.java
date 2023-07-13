import javax.swing.tree.TreeNode;
import java.util.*;

public class Main {
    public void main(String[] args) {
        TreeNode root = generateBinaryTree();
        TreeNode target = new TreeNode(5);
        int k = 2;
        System.out.println(distanceK(root, target, k));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k == 0){
            return new ArrayList<>(Arrays.asList(target.val));
        }

        Map<TreeNode, List<TreeNode>> graph = createGraph(root);

        Set<TreeNode> visited = new HashSet<>();
        List<Integer> kDistanceAway = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);

        while(k-- > 0 && !queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                List<TreeNode> neighbours = graph.get(queue.poll());

                for(TreeNode neighbour : neighbours){
                    if(!visited.contains(neighbour)){
                        if(k != 0){
                            queue.offer(neighbour);
                            visited.add(neighbour);
                        } else {
                            kDistanceAway.add(neighbour.val);
                        }
                    }
                }
            }
        }

        return kDistanceAway;
    }

    public Map<TreeNode, List<TreeNode>> createGraph(TreeNode root){
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                graph.putIfAbsent(node, new ArrayList<>());

                if(node.left != null){
                    queue.offer(node.left);
                    addEdge(graph, node, node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                    addEdge(graph, node, node.right);
                }
            }
        }
        return graph;
    }

    public void addEdge(Map<TreeNode, List<TreeNode>> graph, TreeNode node1, TreeNode node2){
        graph.putIfAbsent(node2, new ArrayList<>());
        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }


    public TreeNode generateBinaryTree(int[] arr, int i){
        TreeNode root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new TreeNode(arr[i] == );

            // insert left child
            root.left = generateBinaryTree(arr, 2 * i + 1);

            // insert right child
            root.right = generateBinaryTree(arr, 2 * i + 2);
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}