public class Main {
    public static void main(String[] args) {
        int data = 5;
        Node head = Node.createList(new Integer[]{1,4,7,9});
        Node.print(sortedInsert(head, 5));
    }

    public static Node sortedInsert(Node head, int data) {
        if(head == null){
            Node newNode = new Node(data);
            newNode.next = newNode;
            return newNode;
        }

        if(head.data > data){
            Node newNode = new Node(data);
            newNode.next = head;
            Node firstNode = head;
            while(head.next != firstNode){
                head = head.next;
            }
            head.next = newNode;
            return newNode;
        }

        Node firstNode = head;
        while(true){
            // LastNode
            if(head.next == firstNode){
                Node newNode = new Node(data);
                newNode.next = firstNode;
                head.next = newNode;
                break;
            } else if(head.data <= data && head.next.data >= data) {
                Node next = head.next;
                Node newNode = new Node(data);
                newNode.next = head.next;
                head.next = newNode;
                break;
            }
            head = head.next;
        }
        return firstNode;
    }
}