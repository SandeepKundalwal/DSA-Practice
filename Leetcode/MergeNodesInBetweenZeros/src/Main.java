public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{0,3,1,0,4,5,2,0});
        ListNode.print(mergeNodes(head));
    }

    public static ListNode mergeNodes(ListNode head) {
        ListNode newHead = head.next;
        ListNode modifiedList = head.next;

        int sum = 0;
        while(newHead != null){
            if(newHead.val != 0){
                sum += newHead.val;
            } else {
                modifiedList.val = sum;
                modifiedList.next = newHead.next;
                modifiedList = modifiedList.next;
                sum = 0;
            }

            newHead = newHead.next;
        }

        return head.next;
    }
}