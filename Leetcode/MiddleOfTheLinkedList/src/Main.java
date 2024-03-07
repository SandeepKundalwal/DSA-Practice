public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new Integer[]{1,2,3,4,5,6});
        ListNode mid = middleNode(head);
        ListNode.print(mid);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}