public class Main {
    static boolean ans;
    static ListNode itHead;
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new Integer[]{10,1,13,6,9,5});
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ans = true;
        itHead = head;
        f(head);
        return ans;
    }

    public static void f(ListNode startHead){
        if(startHead == null){
            return;
        }

        f(startHead.next);

        // System.out.println(itHead.val + " " + startHead.val);

        if(itHead.val != startHead.val){
            ans = false;
            return;
        }
        itHead = itHead.next;
    }
}