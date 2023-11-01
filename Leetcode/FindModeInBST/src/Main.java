import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Need to make tree data structure");
    }

    static int countNodes = 0;
    static TreeNode prevNode = null;
    static int maxMode = Integer.MIN_VALUE;
    public static int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        findModes(root, modes);

        return modes.stream().mapToInt(i -> i).toArray();
    }

    public static void findModes(TreeNode root, List<Integer> modes){
        if(root == null){
            return;
        }

        findModes(root.left, modes);

        if(modes.isEmpty()){
            maxMode = 1;
            countNodes = 1;
            modes.add(root.val);
        } else {
            if(prevNode != null && prevNode.val == root.val){
                countNodes++;
            } else {
                countNodes = 1;
            }

            if(maxMode < countNodes){
                modes.clear();
                modes.add(root.val);
                maxMode = countNodes;
            } else if(maxMode == countNodes) {
                modes.add(root.val);
            }
        }

        prevNode = root;
        findModes(root.right, modes);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
        }
    }
}