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

        for(Integer e : list){
            Node newNode = new Node(e);
            copyHead.next = newNode;
            copyHead = copyHead.next;
        }
        copyHead.next = head.next;
        return head.next;
    }

    public static void print(Node head){
        Node startNode = head;
        System.out.print(startNode.data + " ");
        while(head.next != startNode){
            System.out.print(head.next.data + " ");
            head = head.next;
        }
    }


}