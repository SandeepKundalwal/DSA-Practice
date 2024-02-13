import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int to_delete[] = {3,5};
        TreeNode root = TreeNode.generateTree(new Integer[]{1,2,3,4,5,6,7});
        System.out.println(delNodes(root, to_delete));
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> removeSet = new HashSet<>();
        for(int delete : to_delete){
            removeSet.add(delete);
        }

        List<TreeNode> forest = new ArrayList<>();
        if(!removeSet.contains(root.val)){
            forest.add(root);
        }
        f(root, null, removeSet, forest);
        return forest;
    }

    public static void f(TreeNode root, TreeNode parent, Set<Integer> removeSet, List<TreeNode> forest){
        if(root == null){
            return;
        }

        f(root.left, root, removeSet, forest);
        f(root.right, root, removeSet, forest);

        if(removeSet.contains(root.val)){
            if(root.left != null){
                forest.add(root.left);
            }

            if(root.right != null){
                forest.add(root.right);
            }

            if(parent != null){
                if(parent.left != null && parent.left.val == root.val){
                    parent.left = null;
                    return;
                }

                if(parent.right != null && parent.right.val == root.val){
                    parent.right = null;
                    return;
                }
            }
        }
    }
}