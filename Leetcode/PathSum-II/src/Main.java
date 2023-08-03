import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Need To Make A Function To Generate & Print Tree: " + pathSum(null, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> rootToLeafPaths = new ArrayList<>();
        if(root == null){
            return rootToLeafPaths;
        }
        findRootToLeafPaths(root, root.val, targetSum, new ArrayList<>(Arrays.asList(root.val)), rootToLeafPaths);
        return rootToLeafPaths;
    }

    public static void findRootToLeafPaths(TreeNode root, int currSum, int targetSum, List<Integer> currPath, List<List<Integer>> rootToLeafPaths){
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                rootToLeafPaths.add(new ArrayList<>(currPath));
            }
            return;
        }

        if(root.left != null){
            currPath.add(root.left.val);
            findRootToLeafPaths(root.left, currSum + root.left.val, targetSum, currPath, rootToLeafPaths);
            currPath.remove(currPath.size() - 1);
        }

        if(root.right != null){
            currPath.add(root.right.val);
            findRootToLeafPaths(root.right, currSum + root.right.val, targetSum, currPath, rootToLeafPaths);
            currPath.remove(currPath.size() - 1);
        }
    }
}