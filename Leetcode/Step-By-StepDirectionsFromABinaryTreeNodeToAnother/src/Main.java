import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class Main {
    static String shortestPath;
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{5,1,2,3,null,6,4});
        int startValue = 3;
        int destValue = 6;
        System.out.println(getDirections(root, startValue, destValue));
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        shortestPath = new String();
        Map<Integer, Directions> nodes = new HashMap<>();
        createTree(root, -1, nodes);

        f(startValue, destValue, new StringBuilder(), new HashSet<>(), nodes);

        return shortestPath;
    }

    public static void f(int startValue, int destValue, StringBuilder path, Set<Integer> visited, Map<Integer, Directions> nodes){
        if(startValue == destValue){
            shortestPath = path.toString();
            return;
        }

        visited.add(startValue);
        Directions direction = nodes.get(startValue);

        if(direction.up != -1 && !visited.contains(direction.up)){
            path.append("U");
            f(direction.up, destValue, path, visited, nodes);
            path.deleteCharAt(path.length() - 1);
        }

        if(direction.left != -1 && !visited.contains(direction.left)){
            path.append("L");
            f(direction.left, destValue, path, visited, nodes);
            path.deleteCharAt(path.length() - 1);
        }

        if(direction.right != -1 && !visited.contains(direction.right)){
            path.append("R");
            f(direction.right, destValue, path, visited, nodes);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void createTree(TreeNode root, int prevNode, Map<Integer, Directions> nodes){
        if(root == null){
            return;
        }

        nodes.put(root.val, new Directions(prevNode, root.left == null ? -1 : root.left.val, root.right == null ? -1 : root.right.val));

        createTree(root.left, root.val, nodes);
        createTree(root.right, root.val, nodes);
    }

    static class Directions{
        int up;
        int left;
        int right;

        public Directions(int up, int left, int right){
            this.up = up;
            this.left = left;
            this.right = right;
        }
    }
}