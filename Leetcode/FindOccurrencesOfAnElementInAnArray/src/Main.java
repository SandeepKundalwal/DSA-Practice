import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,3,1,7};
        int queries[] = {1,3,2,4};
        int x = 1;
        System.out.println(Arrays.toString(occurrencesOfElement(nums, queries, x)));
    }

    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length;

        List<Integer> occurences = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(nums[i] == x){
                occurences.add(i);
            }
        }

        int q = queries.length;
        int answer[] = new int[q];
        for(int i = 0; i < q; i++){
            answer[i] = queries[i] <= occurences.size() ? occurences.get(queries[i] - 1) : -1;
        }

        return answer;
    }
}