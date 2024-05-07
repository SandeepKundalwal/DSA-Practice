import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new Integer[]{3,2,1,3,2,1,3,2,1});
        System.out.println(removeNodes(head));
    }

    public static ListNode removeNodes(ListNode head) {
        ListNode reverseHead = reverse(head);

        int maxi = reverseHead.val;
        ListNode newHead = reverseHead;
        ListNode finalHead = newHead;

        ListNode p = reverseHead.next;
        while(p != null){
            if(p.val >= maxi){
                maxi = p.val;
                newHead.next = p;
                newHead = newHead.next;
            }
            p = p.next;
        }
        newHead.next = null;

        return reverse(finalHead);
    }

    public static ListNode reverse(ListNode curr){
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}