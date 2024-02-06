import java.util.*;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        TreeNode root = TreeNode.generateTree(new Integer[]{1,2,3,4,5,6,7,null,null,null,null,null,8});
//        TreeNode root = TreeNode.generateTree(new Integer[]{1,3,null,5,7,8,null,null,null,9});
//        TreeNode root = TreeNode.generateTree(new Integer[]{16,17,null,7,15,null,null,9,6,null,null,5,3,13,14});

        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        generateGraph(root, graph);

        int count[] = new int[1];
        Set<TreeNode> visited = new HashSet<>();
        for(Map.Entry<TreeNode, List<TreeNode>> it : graph.entrySet()){
            TreeNode currRoot = it.getKey();
            if(findSpecialNodes(count, 0, k,  currRoot, graph)){
                count[0]++;
            }
        }

        System.out.println(count[0]);
    }

    public static boolean findSpecialNodes(int count[], int depth, int k, TreeNode root, Map<TreeNode, List<TreeNode>> graph){
        if(graph.get(root).isEmpty()){
            return depth == k;
        }

        for(TreeNode nextNode : graph.get(root)){
            if(findSpecialNodes(count, depth + 1, k, nextNode, graph)){
                return true;
            }
        }

        return false;
    }

    public static void generateGraph(TreeNode root, Map<TreeNode, List<TreeNode>> graph){
        if(root == null){
            return;
        }

        if(!graph.containsKey(root)){
            graph.put(root, new ArrayList<>());
        }

        if(root.left != null){
            graph.get(root).add(root.left);
            generateGraph(root.left, graph);
        }

        if(root.right != null){
            graph.get(root).add(root.right);
            generateGraph(root.right, graph);
        }
    }

}