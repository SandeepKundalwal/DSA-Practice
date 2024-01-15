import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int start = 3;
        TreeNode root = TreeNode.generateTree(new Integer[]{1,5,3,null,4,10,6,9,2});
        System.out.println(amountOfTime(root, start));
    }

    public static int amountOfTime(TreeNode root, int start) {
        if(root == null) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        generateGraph(root, graph);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> alreadyInfected = new HashSet<>();
        queue.offer(start);

        int minutes = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean newlyInfected = false;
            while(size-- > 0){
                int node = queue.remove();
                if(!alreadyInfected.contains(node)){
                    alreadyInfected.add(node);
                    List<Integer> neighbours = graph.get(node);
                    for(Integer nodes : neighbours){
                        if(!alreadyInfected.contains(nodes)){
                            queue.offer(nodes);
                            newlyInfected = true;
                        }
                    }
                }
            }
            if(newlyInfected) minutes++;
        }

        return minutes;
    }

    public static void generateGraph(TreeNode root, Map<Integer, List<Integer>> graph){
        if(root == null){
            return;
        }

        if(!graph.containsKey(root.val)){
            graph.put(root.val, new ArrayList<>());
        }

        if(root.left != null){
            if(!graph.containsKey(root.left.val)){
                graph.put(root.left.val, new ArrayList<>());
            }
            graph.get(root.val).add(root.left.val);
            graph.get(root.left.val).add(root.val);
            generateGraph(root.left, graph);
        }

        if(root.right != null){
            if(!graph.containsKey(root.right.val)){
                graph.put(root.right.val, new ArrayList<>());
            }
            graph.get(root.val).add(root.right.val);
            graph.get(root.right.val).add(root.val);
            generateGraph(root.right, graph);
        }
    }
}