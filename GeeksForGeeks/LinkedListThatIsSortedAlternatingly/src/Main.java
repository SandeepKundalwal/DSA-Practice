public class Main {
    public static void main(String[] args) {
        Node head = Node.createList(new Integer[]{1,9,2,8,3,7});
        Node.print(sort(head));
    }

    public static Node sort(Node head){
        //your code here, return the head of the sorted list
        Node first = new Node(-1);
        Node dF = first;

        Node second = new Node(-1);
        Node dS = second;

        boolean turn = true;
        while(head != null){
            if(turn){
                dF.next = head;
                dF = dF.next;
            } else {
                dS.next = head;
                dS = dS.next;
            }
            turn = !turn;
            head = head.next;
        }

        first = first.next;
        second = second.next;

        // reverse second
        Node prev = null;
        Node next = null;
        Node curr = second;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        return first;
    }
}