import java.util.ArrayList;
import java.util.List;

public class FirstIntuition {
    public static List<TreeNode> generateTrees(int n){
        List<TreeNode> allBSTs = new ArrayList<>();

        if(n == 1){
            allBSTs.add(new TreeNode(1));
            return allBSTs;
        }

        int keys[] = new int[n];
        for(int i = 0; i < keys.length; i++){
            keys[i] = i + 1;
        }

        List<List<Integer>> allCombinations = new ArrayList<>();

        generateAllCombinations(0, keys, allCombinations);

        for(List<Integer> tree : allCombinations){
            TreeNode root = null;

            for(Integer key : tree){
                root = createBST(root, key);
            }

            if(!containsIdenticalBST(root, allBSTs)){
                allBSTs.add(root);
            }
        }

        return allBSTs;
    }

    public static boolean containsIdenticalBST(TreeNode root, List<TreeNode> allBSTs){
        for(TreeNode anotherTree : allBSTs){
            if(isIdentical(anotherTree, root)){
                return true;
            }
        }
        return false;
    }

    public static boolean isIdentical(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        } else if(root1 == null && root2 != null){
            return false;
        } else if(root1 != null && root2 == null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }


    public static TreeNode createBST(TreeNode root, int key){
        if(root == null){
            root = new TreeNode(key);
            return root;
        }

        if(key < root.val){
            root.left = createBST(root.left, key);
        } else if(key > root.val){
            root.right = createBST(root.right, key);
        }

        return root;
    }

    public static void generateAllCombinations(int idx, int keys[], List<List<Integer>> allCombinations){
        if(idx == keys.length){
            List<Integer> permutation = new ArrayList<>();
            for(int key : keys){
                permutation.add(key);
            }
            allCombinations.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = idx; i < keys.length; i++){
            swap(idx, i, keys);
            generateAllCombinations(idx + 1, keys, allCombinations);
            swap(idx, i, keys);
        }
    }

    public static void swap(int i, int j, int keys[]){
        int temp = keys[i];
        keys[i] = keys[j];
        keys[j] = temp;
    }
}
