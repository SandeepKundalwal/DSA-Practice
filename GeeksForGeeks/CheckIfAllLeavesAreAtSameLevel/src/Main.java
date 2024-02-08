public class Main {
    public static void main(String[] args) {
        Node root = Node.generateTree(new Integer[]{10,20,30,10,15});
        System.out.println(check(root));
    }

    static boolean check(Node root)
    {
        // Your code here
        Integer[] prevLevel = new Integer[1];

        return !f(root, 1, prevLevel);
    }

    static boolean f(Node root, int currLevel, Integer prevLevel[]){
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            if(prevLevel[0] == null || prevLevel[0] == currLevel){
                prevLevel[0] = currLevel;
                return false;
            } else{
                return true;
            }
        }

        boolean left = f(root.left, currLevel + 1, prevLevel);
        boolean right = f(root.right, currLevel + 1, prevLevel);

        return left || right;
    }
}