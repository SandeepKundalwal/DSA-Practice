import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int d = 2;
        int jobDifficulty[] = {6,5,4,3,2,1};
        System.out.println(minDifficulty(jobDifficulty, d));
    }

    // divide the arr into d parts such that we get minDifficulty
    // mayb matrix chain multiplication template
    public static int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d) return -1;

        int MEMO[][] = new int[jobDifficulty.length + 1][d + 1];
        for(int row[] : MEMO){
            Arrays.fill(row, -1);
        }

        return f(0, jobDifficulty, d, MEMO);
    }

    public static int f(int idx, int jobDifficulty[], int d, int MEMO[][]){
        if(d == 1){
            return findDifficulty(idx, jobDifficulty.length, jobDifficulty);
        }

        if(idx >= jobDifficulty.length){
            return (int) 1e5;
        }

        if(MEMO[idx][d] != -1){
            return MEMO[idx][d];
        }

        int difficulty = (int) 1e5;
        for(int i = idx; i < jobDifficulty.length; i++){
            int currDifficulty = findDifficulty(idx, i, jobDifficulty);
            difficulty = Math.min(difficulty, currDifficulty + f(i + 1, jobDifficulty, d - 1, MEMO));
        }

        return MEMO[idx][d] = difficulty;
    }

    public static int findDifficulty(int start, int end, int jobDifficulty[]){
        if(start >= jobDifficulty.length){
            return (int) 1e5;
        }

        if(end >= jobDifficulty.length){
            end = end - 1;
        }

        if(start == end) return jobDifficulty[start];

        int maxi = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++){
            maxi = Math.max(maxi, jobDifficulty[i]);
        }
        return maxi;
    }
}