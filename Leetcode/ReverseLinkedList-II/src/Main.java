public class Main {
    public static void main(String[] args) {
        int left = 2;
        int right = 3;
        int nums[] = {1, 2, 4, 5, 6};
        ListNode head = generateList(nums);
        ListNode reversedList = reverseBetween(head, left, right);

        System.out.print("Reversed List: ");
        while(reversedList != null){
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
    }

    /**
     Cases To Handle:
     1. If we have to reverse the whole list
     2. If we have to reverse from start to somewhere before the end of the list
     3. If we have to reverse from somewhere in the middle till the end of the list
     4. If we have to reverse the middle nodes
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right){
            return head;
        }

        ListNode reverseHead = null;
        // CASE-2
        if(left == 1){
            ListNode pair[] = reverseList(head, left, right);
            // CASE-1
            if(pair[1] == null){
                reverseHead = pair[0];
                // CASE-4
            } else {
                reverseHead = pair[0];
                head.next = pair[1];
            }
        } else {
            reverseHead = head;
            // 1->2->3->4->5, left = 3, right = 4. StartLeftPrev will have reference of node 2.
            ListNode startLeftPrev = null;

            int originalLeft = left;
            while(originalLeft-- > 1){
                startLeftPrev = head;
                head = head.next;
            }

            ListNode pair[] = reverseList(head, left, right);

            // CASE-3
            if(pair[1] == null){
                startLeftPrev.next = pair[0];
                // CASE-4
            } else {
                startLeftPrev.next = pair[0];
                head.next = pair[1];
            }
        }

        return reverseHead;
    }

    public static ListNode[] reverseList(ListNode head, int left, int right){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null && right-- >= left){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode pair[] = {prev, curr};
        return pair;
    }

    public static ListNode generateList(int nums[]){
        ListNode head = new ListNode(nums[0]);
        ListNode dummy = head;
        for(int i = 1; i < nums.length; i++){
            ListNode newNode = new ListNode(nums[i]);
            dummy.next = newNode;
            dummy = dummy.next;
        }
        return head;
    }
}