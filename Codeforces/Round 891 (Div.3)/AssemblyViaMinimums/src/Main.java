import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            int bN = (n * (n - 1) / 2);
            List<Integer> b = new ArrayList<>();
            for(int i = 0; i < bN; i++){
                b.add(in.nextInt());
            }

            Collections.sort(b);
            assemblyViaMinimums(n, bN, b);
        }
    }

    // find no of unique elements
    // find frequency of each element and then distribute as per the size of the final array
    // divide the as per frequency
    public static void assemblyViaMinimums(int n, int bN, List<Integer> b){
        int k = n - 1;
        int index = 0;
        for(int i = 0; i < n - 1; i++){
            int mini = Integer.MAX_VALUE;

            for(int j = 0; j < k; j++){
                mini = Math.min(mini, b.get(index++));
            }
            k--;
            System.out.print(mini + " ");
        }
        System.out.println(1000000000);
    }
}