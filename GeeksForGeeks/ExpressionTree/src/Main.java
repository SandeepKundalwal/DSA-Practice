public class Main {
    public static void main(String[] args) {
        System.out.println(evalTree(null));
    }

    public static int evalTree(Node root) {
        if(root == null){
            return 0;
        }

        return evaluate(root);
    }

    public static int evaluate(Node root){
        if(root.left == null && root.right == null){
            return Integer.parseInt(root.data);
        }

        int leftOperand = evaluate(root.left);
        int rightOperand = evaluate(root.right);

        int ans = 0;
        if(root.data.equals("+")){
            ans = leftOperand + rightOperand;
        } else if(root.data.equals("-")){
            ans = leftOperand - rightOperand;
        } else if(root.data.equals("*")){
            ans = leftOperand * rightOperand;
        } else {
            ans = leftOperand / rightOperand;
        }

        return ans;
    }
}
