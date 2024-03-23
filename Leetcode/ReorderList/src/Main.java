import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new Integer[]{1,2,3,4});
        reorderList(head);

        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void reorderList(ListNode head) {
        int count = 0;

        ListNode dummyH = head;
        while(dummyH != null){
            count++;
            dummyH = dummyH.next;
        }

        int mid = count / 2;
        if(count % 2 != 0){
            mid++;
        }

        List<ListNode> firstHalf = new ArrayList<>();
        List<ListNode> secondHalf = new ArrayList<>();

        dummyH = head;
        while(dummyH != null){
            if(mid-- > 0){
                firstHalf.add(dummyH);
            } else {
                secondHalf.add(dummyH);
            }
            dummyH = dummyH.next;
        }

        ListNode newH = new ListNode(-1);
        head = newH;

        boolean turn = true;
        int left = 0, right = secondHalf.size() - 1;
        for(int i = 0; i < count; i++){
            if(turn){
                newH.next = firstHalf.get(left++);
            } else {
                newH.next = secondHalf.get(right--);
            }
            turn = !turn;
            newH = newH.next;
        }
        newH.next = null;

        head = head.next;
    }
}