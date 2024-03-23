public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createList(Integer nums[]){
        ListNode head = new ListNode();
        ListNode dummyHead = head;

        for(int num : nums){
            ListNode newNode = new ListNode(num);
            dummyHead.next = newNode;
            dummyHead = dummyHead.next;
        }

        return head.next;
    }
}