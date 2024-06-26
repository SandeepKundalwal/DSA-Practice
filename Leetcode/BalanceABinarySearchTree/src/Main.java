import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{1,null,15,14,17,7,null,null,null,2,12,null,3,9,null,null,null,null,11});
        TreeNode.print(balanceBST(root));
    }

    public static TreeNode balanceBST(TreeNode root) {
        List<TreeNode> allNodes = new ArrayList<>();
        getAllNodes(root, allNodes);

        return f(allNodes, 0, allNodes.size() - 1);
    }

    public static TreeNode f(List<TreeNode> allNodes, int start, int end){
        if(start > end){
            return null;
        }

        int middle = (end + start) / 2;
        TreeNode root = allNodes.get(middle);
        root.left = f(allNodes, start, middle - 1);
        root.right = f(allNodes, middle + 1, end);

        return root;
    }

    public static void getAllNodes(TreeNode root, List<TreeNode> allNodes){
        if(root == null){
            return;
        }

        getAllNodes(root.left, allNodes);
        allNodes.add(root);
        getAllNodes(root.right, allNodes);
    }
}