public class ListNode {
     int val;
     ListNode next;

     public ListNode(){}

     ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode head;
    static public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        ListNode new_node = new ListNode(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }
}
