public class Main {
    public static void main(String[] args) {
        String s = "())(())";
        System.out.println("Two Stacks: " + TwoStacks.longestValidParentheses(s));
        System.out.println("Constant Space: " + ConstantSpace.longestValidParentheses(s));
    }
}