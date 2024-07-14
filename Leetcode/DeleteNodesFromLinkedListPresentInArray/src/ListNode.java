public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode createList(Integer list[]){
        ListNode head = new ListNode(-1);
        ListNode copyHead = head;

        for(Integer e : list) {
            ListNode newNode = new ListNode(e);
            copyHead.next = newNode;
            copyHead = copyHead.next;
        }
        return head.next;
    }

    public static ListNode find(ListNode node, int val){
        while(node.val != val){
            node = node.next;
        }

        return node;
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}