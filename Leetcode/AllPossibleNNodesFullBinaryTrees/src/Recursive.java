import java.util.ArrayList;
import java.util.List;

public class Recursive {
    public static List<TreeNode> allPossibleFBT(int n) {
        if(n % 2 == 0){
            return new ArrayList<>();
        }

        return generateFullBinaryTrees(n);
    }

    public static List<TreeNode> generateFullBinaryTrees(int n){
        if(n == 1){
            List<TreeNode> newArrayList = new ArrayList<>();
            newArrayList.add(new TreeNode(0));
            return newArrayList;
        }

        List<TreeNode> fullBinaryTrees = new ArrayList<>();
        for(int i = 1; i < n; i += 2){
            List<TreeNode> left = generateFullBinaryTrees(i);
            List<TreeNode> right = generateFullBinaryTrees(n - i - 1);

            for(TreeNode leftNode : left){
                for(TreeNode rightNode : right){
                    TreeNode root = new TreeNode(0, leftNode, rightNode);
                    fullBinaryTrees.add(root);
                }
            }
        }
        return fullBinaryTrees;
    }
}
