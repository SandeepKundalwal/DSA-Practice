public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{4,8,5,1,1,null,6});
        System.out.println(averageOfSubtree(root));
    }

    public static int averageOfSubtree(TreeNode root) {
        int count[] = new int[1];
        f(root, count);
        return count[0];
    }

    public static int[] f(TreeNode root, int count[]){
        if(root == null){
            return new int[]{0, 0};
        }

        int left[] = f(root.left, count);
        int right[] = f(root.right, count);

        int numNodes = left[1] + right[1] + 1;
        int subtreeSum = left[0] + right[0] + root.val;
        if(subtreeSum / numNodes == root.val){
            count[0]++;
        }

        return new int[]{subtreeSum, numNodes};
    }
}