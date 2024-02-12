import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int N = 2;
        int M = 2;
        int toys[][] = {
                {1, 100},
                {100, 1000}
        };
        System.out.println(minimumDifference(N, M, toys));
    }

    public static int minimumDifference(int N, int M, int[][] toys) {
        // code here
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                list.add(new Pair(toys[i][j], i));
            }
        }

        Collections.sort(list, (a, b) -> (a.price - b.price));

        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int low = 0, high = 0;
        while(high < list.size()){
            Pair pair = list.get(high);
            hashMap.put(pair.rowIdx, hashMap.getOrDefault(pair.rowIdx, 0) + 1);
            while(hashMap.size() == N){
                ans = Math.min(ans, list.get(high).price - list.get(low).price);
                hashMap.put(list.get(low).rowIdx, hashMap.get(list.get(low).rowIdx) - 1);
                if(hashMap.get(list.get(low).rowIdx) == 0){
                    hashMap.remove(list.get(low).rowIdx);
                }
                low++;
            }
            high++;
        }

        return ans;
    }

    static class Pair{
        int price;
        int rowIdx;

        public Pair(int price, int rowIdx){
            this.price = price;
            this.rowIdx = rowIdx;
        }
    }
}