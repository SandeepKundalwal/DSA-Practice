import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.generateListNode(new Integer[]{1,2,3,4,5,6,7,8});
        int n = 2;
        ListNode.print(removeNthFromEnd(head, n));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();

        while(head != null){
            nodes.add(head);
            head = head.next;
        }

        int nNodes = nodes.size();
        int toRemove = nNodes - n;

        // first Node
        if(toRemove == 0){
            return nodes.get(toRemove).next;
        }

        nodes.get(toRemove - 1).next = nodes.get(toRemove).next;

        return nodes.get(0);
    }
}