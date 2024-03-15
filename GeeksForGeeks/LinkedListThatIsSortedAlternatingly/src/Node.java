class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

    public static Node createList(Integer list[]){
        Node head = new Node(-1);
        Node copyHead = head;

        for(Integer e : list) {
            Node newNode = new Node(e);
            copyHead.next = newNode;
            copyHead = copyHead.next;
        }
        return head.next;
    }

    public static void print(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }


}