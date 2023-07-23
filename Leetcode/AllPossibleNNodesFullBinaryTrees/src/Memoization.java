import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Memoization {
    public static List<TreeNode> allPossibleFBT(int n) {
        if(n % 2 == 0){
            return new ArrayList<>();
        }
        Map<Integer, List<TreeNode>> MEMO = new HashMap<>();
        return generateFullBinaryTrees(n, MEMO);
    }

    public static List<TreeNode> generateFullBinaryTrees(int n, Map<Integer, List<TreeNode>> MEMO){
        if(n == 1){
            List<TreeNode> newArrayList = new ArrayList<>();
            newArrayList.add(new TreeNode(0));
            return newArrayList;
        }

        if(MEMO.containsKey(n)){
            return MEMO.get(n);
        }

        List<TreeNode> fullBinaryTrees = new ArrayList<>();
        for(int i = 1; i < n; i += 2){
            List<TreeNode> left = generateFullBinaryTrees(i, MEMO);
            List<TreeNode> right = generateFullBinaryTrees(n - i - 1, MEMO);

            for(TreeNode leftNode : left){
                for(TreeNode rightNode : right){
                    TreeNode root = new TreeNode(0, leftNode, rightNode);
                    fullBinaryTrees.add(root);
                }
            }
        }
        MEMO.put(n, fullBinaryTrees);
        return fullBinaryTrees;
    }
}
