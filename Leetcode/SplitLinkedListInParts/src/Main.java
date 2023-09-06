import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int k = 3;
        ListNode.push(8);
        ListNode.push(7);
        ListNode.push(6);
        ListNode.push(5);
        ListNode.push(4);
        ListNode.push(3);
        ListNode.push(2);
        ListNode.push(1);

        ListNode parts[] = splitListToParts(ListNode.head, k);

        System.out.println("[");
        for(ListNode part : parts){
            while(part != null){
                System.out.print(part.val + " ");
                part = part.next;
            }
            System.out.println();
        }
        System.out.println("]");
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode parts[] = new ListNode[k];
        if(head == null){
            return parts;
        }

        int nodeCount = countNodes(head);

        // each idx will have a single node or no node at all
        if(nodeCount <= k){
            int idx = 0;
            ListNode prevNode = null;
            while(head != null){
                parts[idx++] = head;
                prevNode = head;
                head = head.next;
                prevNode.next = null;
            }
        } else {
            int idx = 0;
            int nodesPerPart = nodeCount / k;
            int partsWithExtraNodes = nodeCount % k;
            // System.out.println(nodesPerPart + " " + (nodeCount % k));

            // i need to properly distribute the nodes; Basically I need to find out how much nodes are remaining after equal distribution. I have to distribute nodeCount % k amount of nodes to front parts
            ListNode prevNode = null;
            for(int i = 0; i < partsWithExtraNodes; i++){
                int distributeNodes = nodesPerPart + 1;

                parts[idx++] = head;
                while(distributeNodes-- > 0 && head != null){
                    prevNode = head;
                    head = head.next;
                }
                prevNode.next = null;
            }

            int originalNodesPerPart = nodesPerPart;
            while(head != null){
                parts[idx++] = head;
                nodesPerPart = originalNodesPerPart;
                while(nodesPerPart-- > 0 && head != null){
                    prevNode = head;
                    head = head.next;
                }
                prevNode.next = null;
            }
        }

        return parts;
    }

    public static int countNodes(ListNode head){
        int cnt = 0;
        while(head != null){
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}