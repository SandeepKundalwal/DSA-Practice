public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createList(Integer nodes[]){
        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        for(Integer node : nodes){
            ListNode newNode = new ListNode(node);
            dummy.next = newNode;
            dummy = dummy.next;
        }

        return head.next;
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}