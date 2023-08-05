import java.util.ArrayList;
import java.util.List;

public class Memoization {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> MEMO[][] = new ArrayList[n + 1][n + 1];
        return generateAllBSTs(1, n, MEMO);
    }

    public static List<TreeNode> generateAllBSTs(int start, int end, List<TreeNode> MEMO[][]){
        List<TreeNode> allBSTs = new ArrayList<>();

        if(start > end){
            allBSTs.add(null);
            return allBSTs;
        }

        if(MEMO[start][end] != null){
            return MEMO[start][end];
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> leftTree = generateAllBSTs(start, i - 1, MEMO);
            List<TreeNode> rightTree = generateAllBSTs(i + 1, end, MEMO);

            for(TreeNode leftRoot : leftTree){
                for(TreeNode rightRoot : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    allBSTs.add(root);
                }
            }
        }

        return MEMO[start][end] = allBSTs;
    }
}
