import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int queries[] = {3,2,4,8};
        TreeNode root = TreeNode.generateTree(new Integer[]{5,8,9,2,1,3,7,4,6});
        System.out.println(Arrays.toString(treeQueries(root, queries)));
    }

    public static int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> l = new HashMap<>();
        Map<Integer, Integer> r = new HashMap<>();
        height(root, l, r);

        Map<Integer, Integer> h = new HashMap<>();
        f(root.left, r.get(root.val), 1, h, l, r);
        f(root.right, l.get(root.val), 1, h, l, r);

        int ans[] = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            ans[i] = h.get(queries[i]);
        }
        return ans;
    }

    public static void f(TreeNode root, int maxi, int depth, Map<Integer, Integer> h, Map<Integer, Integer> l, Map<Integer, Integer> r){
        if(root == null){
            return;
        }

        h.put(root.val, maxi);

        f(root.left, Math.max(maxi, r.get(root.val) + depth), depth + 1, h, l, r);
        f(root.right, Math.max(maxi, l.get(root.val) + depth), depth + 1, h, l, r);
    }


    public static int height(TreeNode root, Map<Integer, Integer> l, Map<Integer, Integer> r){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left, l, r);
        int rightHeight = height(root.right, l, r);

        l.put(root.val, leftHeight);
        r.put(root.val, rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}