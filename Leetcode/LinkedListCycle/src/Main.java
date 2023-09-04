public class Main {
    public static void main(String[] args) {
        ListNode.push(20);
        ListNode.push(4);
        ListNode.push(15);
        ListNode.push(10);

        /*Create loop for testing */
        ListNode.head.next.next.next.next = ListNode.head;
        System.out.println("Cycle exists: " + hasCycle(ListNode.head));
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}