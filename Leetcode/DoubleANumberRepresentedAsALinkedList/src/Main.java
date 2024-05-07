public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new Integer[]{3,2,1,3,2,1,3,2,1});
        System.out.println(doubleIt(head));
    }

    public static ListNode doubleIt(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            int currVal = curr.val * 2;
            if(currVal >= 10){
                if(prev == null){
                    head = new ListNode(1);
                    head.next = curr;
                } else {
                    prev.val += 1;
                }
            }

            curr.val = currVal % 10;
            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}