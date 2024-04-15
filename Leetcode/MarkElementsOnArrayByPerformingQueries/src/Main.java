import java.util.*;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,2,1,2,3,1};
        int queries[][] = {{1,2},{3,3},{4,2}};
        System.out.println(Arrays.toString(unmarkedSumArray(nums, queries)));
    }

    public static long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(n, new Comparator<Pair>(){

            @Override
            public int compare(Pair a, Pair b){
                if(a.val == b.val){
                    return a.index - b.index;
                }

                return a.val - b.val;
            }
        });

        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            pq.offer(new Pair(nums[i], i));
        }

        Set<Integer> set = new HashSet<>();

        long ans[] = new long[m];
        for(int i = 0; i < m; i++){
            int index = queries[i][0];
            int removeTopKElements = queries[i][1];

            if(!set.contains(index)){
                sum -= nums[index];
                set.add(index);
            }

            while(!pq.isEmpty() && removeTopKElements > 0){
                Pair top = pq.remove();
                if(!set.contains(top.index)){
                    sum -= top.val;
                    set.add(top.index);
                    removeTopKElements--;
                }
            }

            ans[i] = sum;
        }

        return ans;
    }

    static class Pair{
        int val;
        int index;

        public Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
}