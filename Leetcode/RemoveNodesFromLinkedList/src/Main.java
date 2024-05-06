import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new Integer[]{3,2,1,3,2,1,3,2,1});
        System.out.println(removeNodes(head));
    }

    public static ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        fillStack(head, stack);

        ListNode newHead = new ListNode(-1);
        ListNode finalHead = newHead;

        while(head != null){
            if(!stack.isEmpty() && head.val >= stack.peek()){
                newHead.next = new ListNode(head.val);;
                newHead = newHead.next;

                if(stack.peek() == head.val){
                    stack.pop();
                }
            }
            head = head.next;
        }

        return finalHead.next;
    }

    public static void fillStack(ListNode head, Stack<Integer> stack){
        if(head == null){
            return;
        }

        fillStack(head.next, stack);

        if(stack.isEmpty() || stack.peek() <= head.val){
            stack.push(head.val);
        }
    }
}