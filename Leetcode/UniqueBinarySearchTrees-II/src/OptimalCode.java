import java.util.ArrayList;
import java.util.List;

public class OptimalCode {
    public static List<TreeNode> generateTrees(int n) {
        return generateAllBSTs(1, n);
    }

    public static List<TreeNode> generateAllBSTs(int start, int end){
        List<TreeNode> allBSTs = new ArrayList<>();

        if(start > end){
            allBSTs.add(null);
            return allBSTs;
        }

        if(start == end){
            allBSTs.add(new TreeNode(start));
            return allBSTs;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> leftTree = generateAllBSTs(start, i - 1);
            List<TreeNode> rightTree = generateAllBSTs(i + 1, end);

            for(TreeNode leftRoot : leftTree){
                for(TreeNode rightRoot : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    allBSTs.add(root);
                }
            }
        }

        return allBSTs;
    }
}
