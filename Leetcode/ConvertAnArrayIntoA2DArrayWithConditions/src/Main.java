import java.util.*;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,3,4,1,2,3,1};
        System.out.println(findMatrix(nums));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        int freq[] = new int[nums.length + 1];
        List<List<Integer>> matrix = new ArrayList<>();

        int maxFreq = 0;
        for(int num : nums){
            freq[num]++;
            maxFreq = Math.max(maxFreq, freq[num]);
        }

        for(int i = 0; i < maxFreq; i++){
            matrix.add(new ArrayList<>());
            for(int j = 0; j < nums.length + 1; j++){
                if(freq[j] > 0){
                    freq[j]--;
                    matrix.get(i).add(j);
                }
            }
        }

        return matrix;
    }
}