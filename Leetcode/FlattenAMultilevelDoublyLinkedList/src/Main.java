public class Main {
    public static void main(String[] args) {
        System.out.println("Need to make structure of Multi-Level Linked List.");
    }

    public static Node flatten(Node head) {
        if(head == null) return head;

        Node newHead = head;
        while(head != null){
            if(head.child != null){
                Node next = head.next;
                Node exploreChildNext = head.child;
                Node exploreChildPrev = head.child;

                while(exploreChildNext.next != null){
                    exploreChildNext = exploreChildNext.next;
                }

                while(exploreChildPrev.prev != null){
                    exploreChildPrev = exploreChildPrev.prev;
                }

                // connect child from front
                head.next = exploreChildPrev;
                exploreChildPrev.prev = head;

                // connect child from end
                if(next != null){
                    exploreChildNext.next = next;
                    next.prev = exploreChildNext;
                }

                head.child = null;
            }
            head = head.next;
        }
        return newHead;
    }
}