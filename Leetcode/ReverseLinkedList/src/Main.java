public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new Integer[]{10,1,13,6,9,5});
        ListNode reversedHead = reverseList(head);
        ListNode.print(reversedHead);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
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