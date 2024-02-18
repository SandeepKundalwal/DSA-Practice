public class Main {
    public static void main(String[] args) {
        Node root = Node.generateTree(new Integer[]{67, 34, 82, 12, 45, 78});
        System.out.println(sumOfLeafNodes(root));
    }

    public static int sumOfLeafNodes(Node root)
    {
        if(root == null) return 0;

        int sum[] = {0};
        f(root, sum);
        return sum[0];
    }

    public static void f(Node root, int sum[]){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            sum[0] += root.data;
            return;
        }

        f(root.left, sum);
        f(root.right, sum);
    }
}