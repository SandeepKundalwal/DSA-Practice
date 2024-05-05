public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new Integer[]{10,1,13,6,9,5});
        ListNode node = ListNode.find(head, 13);
        deleteNode(node);
        ListNode.print(head);
    }

    public static void deleteNode(ListNode node) {
        ListNode prevNode = null;
        while(node.next != null){
            prevNode = node;
            node.val = node.next.val;
            node = node.next;
        }

        prevNode.next = null;
    }
}