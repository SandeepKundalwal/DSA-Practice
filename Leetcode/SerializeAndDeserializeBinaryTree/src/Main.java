public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{1,2,3,null,null,4,5});
        String serializedTree = TreeNode.serialize(root);
        TreeNode deserializedRoot = TreeNode.deserialize(serializedTree);
    }
}