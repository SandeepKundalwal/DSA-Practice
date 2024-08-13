import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int candidates[] = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        f(0, target, candidates, new ArrayList<>(), answer);
        return answer;
    }

    public static void f(int idx, int target, int candidates[], List<Integer> currCandidates, List<List<Integer>> answer){
        if(target == 0){
            answer.add(new ArrayList<>(currCandidates));
            return;
        }

        if(idx >= candidates.length || target < 0){
            return;
        }

        for(int i = idx; i < candidates.length; i++){
            if(i == idx || candidates[i - 1] != candidates[i]){
                currCandidates.add(candidates[i]);
                f(i + 1, target - candidates[i], candidates, currCandidates, answer);
                currCandidates.remove(currCandidates.size() - 1);
            }
        }
    }
}