import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int descriptions[][] = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        TreeNode.print(createBinaryTree(descriptions));
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodesMap = new HashMap<>();
        for(int description[] : descriptions){
            int p = description[0];
            int c = description[1];
            int l = description[2];

            if(!nodesMap.containsKey(p)){
                nodesMap.put(p, new TreeNode(p));
            }

            if(!nodesMap.containsKey(c)){
                nodesMap.put(c, new TreeNode(c));
            }

            if(l == 1){
                nodesMap.get(p).left = nodesMap.get(c);
            } else {
                nodesMap.get(p).right = nodesMap.get(c);
            }
        }

        // find the root; One which is never a child;
        for(int description[] : descriptions){
            nodesMap.remove(description[1]);
        }

        return nodesMap.entrySet().iterator().next().getValue();
    }
}