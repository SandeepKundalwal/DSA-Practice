import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String s = "isawsquirrelnearmysquirrelhouseohmy";
        String a = "my";
        String b = "squirrel";
        int k = 15;
        System.out.println(beautifulIndices(s, a, b, k));
    }

    public static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int sLen = s.length();
        int aLen = a.length();
        int bLen = b.length();

        List<Integer> foundAIndices = new ArrayList<>();
        for(int i = 0; i <= sLen - aLen; i++){
            String subString = s.substring(i, i + aLen);
            if(subString.equals(a)){
                foundAIndices.add(i);
            }
        }

        List<Integer> foundBIndices = new ArrayList<>();
        for(int i = 0; i <= sLen - bLen; i++){
            String subString = s.substring(i, i + bLen);
            if(subString.equals(b)){
                foundBIndices.add(i);
            }
        }

        return getIndices(k, foundAIndices, foundBIndices);
    }

    private static List<Integer> getIndices(int k, List<Integer> foundAIndices, List<Integer> foundBIndices) {
        List<Integer> indices = new ArrayList<>();
        for(int indexA : foundAIndices){
            int left = 0, right = foundBIndices.size() - 1;
            while(left <= right){
                int mid = left + ((right - left) / 2);
                int indexB = foundBIndices.get(mid);

                if(Math.abs(indexB - indexA) <= k){
                    indices.add(indexA);
                    break;
                } else if(indexB < indexA){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return indices;
    }
}