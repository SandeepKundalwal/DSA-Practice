import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        ListNode head = ListNode.createList(new Integer[]{1,2,3,4,5});
        ListNode.print(modifiedList(nums, head));
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        while(set.contains(head.val)){
            head = head.next;
        }

        ListNode prev = new ListNode(-1);
        ListNode dummy = head;

        while(dummy != null){
            if(set.contains(dummy.val)){
                prev.next = null;
            } else {
                prev.next = dummy;
                prev = prev.next;
            }
            dummy = dummy.next;
        }

        return head;
    }
}