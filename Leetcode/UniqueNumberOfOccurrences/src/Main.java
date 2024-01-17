import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int arr[] = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int element : arr){
            if(!hashMap.containsKey(element)){
                hashMap.put(element, 1);
            } else {
                hashMap.put(element, hashMap.get(element) + 1);
            }
        }

        int freq[] = new int[1001];
        for(Map.Entry<Integer, Integer> it : hashMap.entrySet()){
            int eleFreq = it.getValue();
            if(freq[eleFreq] != 0){
                return false;
            } else {
                freq[eleFreq] = eleFreq;
            }
        }
        return true;
    }
}