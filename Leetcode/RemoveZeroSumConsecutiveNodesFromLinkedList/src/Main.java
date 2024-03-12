import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new Integer[]{1,2,-3,3,1});
        System.out.println(removeZeroSumSublists(head));
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = head;

        List<ListNode> l = new ArrayList<>();
        while(dummy != null){
            l.add(dummy);
            dummy = dummy.next;
        }

        int n = l.size();
        boolean zeroes[] = new boolean[n];

        for(int i = 0; i < n; i++){
            if(zeroes[i]) continue;

            int start = i;
            int count = i;
            int end = i;
            int sum = 0;
            boolean foundZ = false;
            for(int k = i; k < n; k++){
                sum += l.get(k).val;
                if(sum == 0){
                    end = count;
                    foundZ = true;
                }
                count++;
            }

            if(foundZ){
                for(int j = start; j <= end; j++){
                    zeroes[j] = true;
                }
            }
        }

        ListNode dummy1 = new ListNode(-1001);
        ListNode newHead = dummy1;

        for(int i = 0; i < n; i++){
            if(!zeroes[i]){
                // System.out.println(l.get(i).val);
                ListNode newNode = new ListNode(l.get(i).val);
                dummy1.next = newNode;
                dummy1 = dummy1.next;
            }
        }

        return newHead.next;
    }
}