public class Main {
    public static void main(String[] args) {
        Node head = Node.createList(new Integer[]{2,8,3,7});
        deleteNode(head);
        Node.print(head);
    }

    static void deleteNode(Node del_node) {
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;
    }
}