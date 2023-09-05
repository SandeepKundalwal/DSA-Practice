import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(copyRandomList(null));
    }

    public static Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node traverseList = head;
        List<Node> arr = new ArrayList<>();
        Map<Node, Integer> hashIndex = new HashMap<>();

        int index = 0;
        while(traverseList != null){
            Node newNode = new Node(traverseList.val);
            arr.add(newNode);
            hashIndex.put(traverseList, index++);
            traverseList = traverseList.next;
        }

        for(int i = 0; i < arr.size() - 1; i++){
            arr.get(i).next = arr.get(i + 1);
            if(head.random != null){
                int idx = hashIndex.get(head.random);
                arr.get(i).random = arr.get(idx);
            }
            head = head.next;
        }

        arr.get(arr.size() - 1).random = (head.random == null) ? null : arr.get(hashIndex.get(head.random));
        return arr.get(0);
    }
}