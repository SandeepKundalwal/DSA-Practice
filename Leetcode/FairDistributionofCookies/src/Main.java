import java.util.ArrayList;
import java.util.List;

public class Main {
    static int minAbsDiff = Integer.MAX_VALUE;
    static int maxDistribution = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int k = 2;
        int cookies[] = new int[]{8,15,10,20,8};
        System.out.println(distributeCookies(cookies, k));
    }

    public static int distributeCookies(int[] cookies, int k) {
        List<List<Integer>> currentDistribution = new ArrayList<>();
        for(int i = 0; i < k; i++){
            currentDistribution.add(new ArrayList<>());
        }
        backtrack(0, k, 0, currentDistribution, cookies);
        return maxDistribution;
    }

    public static void backtrack(int index, int k, int noOfPartitions, List<List<Integer>> currentDistribution, int[] cookies){
        if(index == cookies.length){
            if(noOfPartitions == k){
                int maxSum = Integer.MIN_VALUE;
                int minSum = Integer.MAX_VALUE;
                for(List<Integer> distribution : currentDistribution){
                    int sumElements = 0;
                    for(int element : distribution){
                        sumElements += element;
                    }
                    maxSum = Math.max(maxSum, sumElements);
                    minSum = Math.min(minSum, sumElements);
                }

                if(maxSum - minSum < minAbsDiff){
                    minAbsDiff = maxSum - minSum;
                    maxDistribution = maxSum;
                }
            }
            return;
        }

        for(int i = 0; i < k; i++){
            if(currentDistribution.get(i).size() > 0){
                currentDistribution.get(i).add(cookies[index]);
                backtrack(index + 1, k, noOfPartitions, currentDistribution, cookies);
                currentDistribution.get(i).remove(currentDistribution.get(i).size() - 1);
            } else {
                currentDistribution.get(i).add(cookies[index]);
                backtrack(index + 1, k, noOfPartitions + 1, currentDistribution, cookies);
                currentDistribution.get(i).remove(currentDistribution.get(i).size() - 1);
                break;
            }
        }
    }
}