import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{7,7,10,1,7,1,2,1,5});
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int result[] = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = null;

        int idx = 1;
        int firstMinOrMax = 0, prevMinOrMax = 0;
        while(curr.next != null){
            next = curr.next;
            if((prev.val > curr.val && curr.val < next.val) || (prev.val < curr.val && curr.val > next.val)){
                if(firstMinOrMax == 0){
                    prevMinOrMax = idx;
                    firstMinOrMax = idx;
                } else {
                    result[0] = Math.min(result[0], idx - prevMinOrMax);
                    result[1] = Math.max(result[1], idx - firstMinOrMax);

                    prevMinOrMax = idx;
                }
            }

            idx++;
            prev = curr;
            curr = curr.next;
        }

        return result[0] == Integer.MAX_VALUE ? new int[]{-1, -1} : result;
    }
}