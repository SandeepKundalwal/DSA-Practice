import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        int n = 5;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), ans);
        return ans;
    }

    public static void backtrack(int idx, int n, int k, List<Integer> currList, List<List<Integer>> ans){
        if(currList.size() == k){
            ans.add(new ArrayList<>(currList));
            return;
        }

        for(int i = idx; i <= n; i++){
            currList.add(i);
            backtrack(i + 1, n, k, currList, ans);
            currList.remove(currList.size() - 1);
        }
    }
}