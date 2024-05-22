import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> allPartitions = new ArrayList<>();
        f(0, s, new ArrayList<>(), allPartitions);
        return allPartitions;
    }

    public static void f(int idx, String s, List<String> currPartition, List<List<String>> allPartitions){
        if(idx == s.length()){
            allPartitions.add(new ArrayList<>(currPartition));
            return;
        }

        for(int i = idx; i < s.length(); i++){
            String currS = s.substring(idx, i + 1);

            if(isPalindrome(currS)){
                currPartition.add(currS);
                f(i + 1, s, currPartition, allPartitions);
                currPartition.remove(currPartition.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s){
        int start = 0, end = s.length() - 1;
        while(start <= end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}