public class Main {
    public static void main(String[] args) {
        int x = 3;
        int nums[] = {1,4,3,2,5,2};
        ListNode head = ListNode.createList(nums);
        ListNode partitionHead = partition(head, x);
        while(partitionHead != null){
            System.out.print(partitionHead.val + " ");
            partitionHead = partitionHead.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }

        ListNode startOfSmallerNodes = null;
        ListNode lastOfSmallerNodes = null;
        ListNode startOfGreaterNodes = null;
        ListNode traverseGreaterNodes = null;

        while(head != null){
            if(head.val >= x){
                if(startOfGreaterNodes == null){
                    startOfGreaterNodes = head;
                    traverseGreaterNodes = head;
                } else {
                    traverseGreaterNodes.next = head;
                    traverseGreaterNodes = traverseGreaterNodes.next;
                }
            } else {
                if(lastOfSmallerNodes == null){
                    startOfSmallerNodes = head;
                    lastOfSmallerNodes = head;
                } else {
                    lastOfSmallerNodes.next = head;
                    lastOfSmallerNodes = lastOfSmallerNodes.next;
                }
            }
            head = head.next;
        }

        if(lastOfSmallerNodes != null){
            lastOfSmallerNodes.next = startOfGreaterNodes;
        }

        if(traverseGreaterNodes != null){
            traverseGreaterNodes.next = null;
        }

        return startOfSmallerNodes == null ? startOfGreaterNodes : startOfSmallerNodes;
    }
}