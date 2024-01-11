import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Need to make Tree Structure.");
    }

    // n^2 or n^2logn
    public int maxAncestorDiff(TreeNode root) {
        List<TreeNode> allNodes = new ArrayList<>();
        getAllNodes(root, allNodes);

        int maxDifference = Integer.MIN_VALUE;
        for(TreeNode node : allNodes){
            maxDifference = Math.max(maxDifference, f(node, node.val));
        }
        return maxDifference;
    }

    public int f(TreeNode root, int rootValue){
        if(root == null){
            return 0;
        }

        int difference = Math.abs(rootValue - root.val);
        difference = Math.max(difference, f(root.left, rootValue));
        difference = Math.max(difference, f(root.right, rootValue));
        return difference;
    }

    public void getAllNodes(TreeNode root, List<TreeNode> allNodes){
        if(root == null){
            return;
        }

        allNodes.add(root);
        getAllNodes(root.left, allNodes);
        getAllNodes(root.right, allNodes);
    }
}