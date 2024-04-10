import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int deck[] = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            queue.offer(i);
        }

        int i = 0;
        int ans[] = new int[n];
        while(!queue.isEmpty()){
            ans[queue.remove()] = deck[i++];
            if(!queue.isEmpty()){
                queue.offer(queue.remove());
            }
        }

        return ans;
    }
}