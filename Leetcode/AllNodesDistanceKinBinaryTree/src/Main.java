import java.util.*;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        TreeNode target = new TreeNode(5);
        Integer nodes[] = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.generateTree(nodes);

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

    public static Map<TreeNode, List<TreeNode>> createGraph(TreeNode root){
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

    public static void addEdge(Map<TreeNode, List<TreeNode>> graph, TreeNode node1, TreeNode node2){
        graph.putIfAbsent(node2, new ArrayList<>());
        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }
}