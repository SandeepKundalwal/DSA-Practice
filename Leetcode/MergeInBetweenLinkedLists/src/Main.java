public class Main {
    public static void main(String[] args) {
        ListNode list1 = ListNode.createList(new Integer[]{10,1,13,6,9,5});
        int a = 2;
        int b = 4;
        ListNode list2 = ListNode.createList(new Integer[]{1000000,1000001,1000002});

        ListNode head = mergeInBetween(list1, a, b, list2);

        ListNode.print(head);
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyL1 = list1;

        ListNode A = null;
        ListNode B = null;

        int count = 1;
        while(dummyL1 != null){
            if(count - 1 < a){
                A = dummyL1;
            } else if (count - 1 == b){
                B = dummyL1;
                break;
            }
            count++;
            dummyL1 = dummyL1.next;
        }

        // System.out.println(A.val + " " + B.val);
        A.next = list2;
        while(list2.next != null){
            list2 = list2.next;
        }
        list2.next = B.next;

        return list1;
    }
}