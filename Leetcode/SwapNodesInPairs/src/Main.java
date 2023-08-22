public class Main {
    public static void main(String[] args) {
        int list[] = {1,2,3,4};
        ListNode head = ListNode.createLinkedList(list);
        ListNode swapHead = swapPairs(head);

        while(swapHead != null){
            System.out.print(swapHead.val + " ");
            swapHead = swapHead.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode startPair[] = reversePair(head);
        ListNode swapHead = startPair[0];
        ListNode endOfPair = startPair[1];
        ListNode curr = startPair[2];
        while(curr != null){
            ListNode pair[] = reversePair(curr);
            endOfPair.next = pair[0];
            endOfPair = pair[1];
            curr = pair[2];
        }
        return swapHead;
    }

    public static ListNode[] reversePair(ListNode head){
        int cnt = 0;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        ListNode endOfPair = head;

        while(curr != null && cnt++ < 2){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return new ListNode[]{prev, endOfPair, curr};
    }
}

