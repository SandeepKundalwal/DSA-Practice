public class Main {
    public static void main(String[] args) {
        Node root = Node.generateTree(new Integer[]{5,3,7,2,4,6,8});
        Node sortedList = flattenBST(root);
        while(sortedList != null){
            System.out.print(sortedList.data + " ");
            sortedList = sortedList.right;
        }
    }

    static Node sortedList;
    public static Node flattenBST(Node root) {
        if(root == null){
            return null;
        }

        sortedList = new Node(-1);
        Node head = sortedList;
        f(root);
        return head.right;
    }

    public static void f(Node root){
        if(root == null){
            return;
        }

        f(root.left);

        Node newNode = new Node(root.data);
        sortedList.left = null;
        sortedList.right = newNode;
        sortedList = sortedList.right;

        f(root.right);
    }
}