public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createLinkedList(Integer nodes[]){
        ListNode head = new ListNode(0);
        ListNode dummy = head;

        for(Integer node : nodes){
            ListNode newNode = new ListNode(node);
            dummy.next = newNode;
            dummy = dummy.next;
        }
        return head.next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}