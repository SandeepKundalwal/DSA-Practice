import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class Main {
    static String shortestPath;
    static StringBuilder shortestPathSB;
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{5,1,2,3,null,6,4});
        int startValue = 3;
        int destValue = 6;
        System.out.println("Using LCA: " + getDirections(root, startValue, destValue));
        System.out.println("Using HashMap: " + getDirectionsHashMap(root, startValue, destValue));
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        shortestPathSB = new StringBuilder();

        TreeNode LCA = findLCA(root, startValue, destValue);

        if(LCA.val == startValue){
            traverse(LCA, new StringBuilder(), false, destValue);
        } else if(LCA.val == destValue){
            traverse(LCA, new StringBuilder(), true, startValue);
        } else {
            traverse(LCA, new StringBuilder(), true, startValue);
            traverse(LCA, new StringBuilder(), false, destValue);
        }

        return shortestPathSB.toString();
    }

    public static void traverse(TreeNode root, StringBuilder path, boolean goingUp, int value){
        if(root.val == value){
            shortestPathSB.append(path.toString());
            return;
        }

        if(root.left != null){
            path.append(goingUp ? "U" : "L");
            traverse(root.left, path, goingUp, value);
            path.deleteCharAt(path.length() - 1);
        }

        if(root.right != null){
            path.append(goingUp ? "U" : "R");
            traverse(root.right, path, goingUp, value);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static TreeNode findLCA(TreeNode root, int startValue, int destValue){
        if(root == null || root.val == startValue || root.val == destValue){
            return root;
        }

        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);

        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }

        return root;
    }

    /*
    Using HashMap and HashSet
     */
    public static String getDirectionsHashMap(TreeNode root, int startValue, int destValue) {
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