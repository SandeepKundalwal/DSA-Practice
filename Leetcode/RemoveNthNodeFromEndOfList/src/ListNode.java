public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode generateListNode(Integer elements[]){
        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        for(int e : elements){
            ListNode listNode = new ListNode(e);
            dummy.next = listNode;
            dummy = dummy.next;
        }

        return head.next;
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
 }