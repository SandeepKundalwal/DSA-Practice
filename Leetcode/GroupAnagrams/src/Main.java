import java.util.*;

public class Main {
    public static void main(String[] args) {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();

        for(String str : strs){
            char strChars[] = str.toCharArray();
            Arrays.sort(strChars);
            String sortedStr = new String(strChars);
            if(!hashMap.containsKey(sortedStr)){
                hashMap.put(sortedStr, new ArrayList<>());
            }
            hashMap.get(sortedStr).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> it : hashMap.entrySet()){
            result.add(it.getValue());
        }

        return result;
    }
}