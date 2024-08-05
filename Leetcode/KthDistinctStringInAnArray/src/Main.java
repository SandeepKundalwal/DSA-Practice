import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String arr[] = {"aaa","aa","a"};
        int k = 1;
        System.out.println(kthDistinct(arr, k));
    }

    public static String kthDistinct(String[] arr, int k) {
        if(arr.length < k) return "";

        Map<String, Integer> hashMap = new LinkedHashMap<>();
        for(String s : arr){
            if(!hashMap.containsKey(s)){
                hashMap.put(s, 0);
            }

            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        for(Map.Entry<String, Integer> it : hashMap.entrySet()){
            if(it.getValue() > 1) continue;

            count++;

            if(count == k) return it.getKey();
        }

        return "";
    }
}