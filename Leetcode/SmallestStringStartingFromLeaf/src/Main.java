import com.sun.source.tree.Tree;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(smallestFromLeaf(root));
    }

    public static String smallestFromLeaf(TreeNode root) {
        String smallestString[] = {""};
        smallestFromLeafUtility(root, new StringBuilder(), smallestString);
        return smallestString[0];
    }

    public static void smallestFromLeafUtility(TreeNode root, StringBuilder currentString, String smallestString[]){
        if(root == null) return;

        currentString.append((char)(root.val + 'a'));
        if(root.left == null && root.right == null){
            currentString.reverse();
            if(smallestString[0].isEmpty() || smallestString[0].compareTo(currentString.toString()) > 0){
                smallestString[0] = new String(currentString);
            }
            currentString.reverse();
        }

        smallestFromLeafUtility(root.left, currentString, smallestString);
        smallestFromLeafUtility(root.right, currentString, smallestString);
        currentString.deleteCharAt(currentString.length() - 1);
    }
}