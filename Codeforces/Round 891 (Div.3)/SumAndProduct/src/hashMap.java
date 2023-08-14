import java.util.HashMap;
import java.util.Map;

// TLE at 4th Test Case
public class hashMap {
    public static int findPairs(long x, long y, int n, int a[]){
        int cnt = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            double sumTarget = x - a[i];
            double multiplicationTarget = (double) y / a[i];

            if(Double.compare(sumTarget, multiplicationTarget) == 0){
                if(hashMap.containsKey((int)sumTarget)){
                    cnt += hashMap.get((int)sumTarget);
                }

                if(hashMap.containsKey(a[i])){
                    hashMap.put(a[i], hashMap.get(a[i]) + 1);
                } else {
                    hashMap.put(a[i], 1);
                }
            }
        }
        return cnt;
    }
}
