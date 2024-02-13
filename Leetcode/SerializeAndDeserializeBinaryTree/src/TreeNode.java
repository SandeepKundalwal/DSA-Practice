import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode generateTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nodes[0]);
        queue.offer(root);

        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode current = queue.poll();

            if (nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.offer(current.left);
            }

            if (i + 1 < nodes.length && nodes[i + 1] != null) {
                current.right = new TreeNode(nodes[i + 1]);
                queue.offer(current.right);
            }
        }

        return root;
    }

    public static String serialize(TreeNode root) {
        if(root == null){
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode treeNode = queue.remove();
                if(treeNode != null){
                    sb.append(Integer.toString(treeNode.val)).append(" ");
                    if(treeNode.left != null){
                        queue.offer(treeNode.left);
                    } else {
                        queue.offer(null);
                    }

                    if(treeNode.right != null){
                        queue.offer(treeNode.right);
                    } else {
                        queue.offer(null);
                    }
                } else {
                    sb.append("N ");
                }
            }
        }


        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }

        String arr[] = data.split(" ");

        int end = arr.length - 1;
        for(int i = arr.length - 1; i >= 0; i--){
            if(!arr[i].equals("N")){
                end = i;
                break;
            }
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int idx = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.remove();

                int leftChildIdx = 2*idx+1;
                if(leftChildIdx <= end){
                    if(arr[leftChildIdx].equals("N")){
                        node.left = null;
                    } else {
                        TreeNode nodeL = new TreeNode(Integer.parseInt(arr[leftChildIdx]));
                        node.left = nodeL;
                        queue.offer(nodeL);
                    }
                }

                int rightChildIdx = 2*idx+2;
                if(rightChildIdx <= end){
                    if(arr[rightChildIdx].equals("N")){
                        node.right = null;
                    } else {
                        TreeNode nodeR = new TreeNode(Integer.parseInt(arr[rightChildIdx]));
                        node.right = nodeR;
                        queue.offer(nodeR);
                    }
                }
                idx++;
            }
        }

        return root;
    }
}
