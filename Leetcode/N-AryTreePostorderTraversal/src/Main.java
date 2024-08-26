import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Node root = Node.createTree(new Integer[]{1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14});
        System.out.println(postorder(root));
    }

    public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        f(root, result);
        return result;
    }

    public static void f(Node root, List<Integer> result){
        if(root == null){
            return;
        }

        for(Node children : root.children){
            f(children, result);
        }
        result.add(root.val);
    }
}