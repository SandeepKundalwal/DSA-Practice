public class Main {
    public static void main(String[] args) {
        int preorder[] = {3,9,20,15,7};
        int inorder[] = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Preorder Traversal: ");
        TreeNode.printPreorderTraversal(root);
        System.out.println("\nInorder Traversal: ");
        TreeNode.printInorderTraversal(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preIdx[] = {0};
        return f(preIdx, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode f(int preIdx[], int start, int end, int preorder[], int inorder[]){
        if(preIdx[0] >= preorder.length){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx[0]]);
        for(int i = start; i <= end; i++){
            if(inorder[i] == preorder[preIdx[0]]){
                if(start <= i - 1){
                    preIdx[0]++;
                    root.left = f(preIdx, start, i - 1, preorder, inorder);
                }

                if(i + 1 <= end){
                    preIdx[0]++;
                    root.right = f(preIdx, i + 1, end, preorder, inorder);
                }

                break;
            }
        }

        return root;
    }
}