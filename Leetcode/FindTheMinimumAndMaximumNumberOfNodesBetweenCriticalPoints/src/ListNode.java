public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createLinkedList(int list[]){
        ListNode head = new ListNode(list[0]);
        ListNode dummyNode = head;

        for(int i = 1; i < list.length; i++){
            ListNode newNode = new ListNode(list[i]);
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
        }
        return head;
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.printf(head.val + " ");
            head = head.next;
        }
    }
}