import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.generateListNode(new Integer[]{1,2,3,4,5,6,7,8});
        int n = 2;
        ListNode.print(removeNthFromEnd(head, n));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode faster = head;

        while(n > 0){
            faster = faster.next;
            n--;
        }

        ListNode slower = head;
        ListNode prevSlower = null;
        while(faster != null){
            prevSlower = slower;
            slower = slower.next;
            faster = faster.next;
        }

        if(prevSlower == null){
            return slower.next;
        }

        prevSlower.next = slower.next;

        return head;
    }
}