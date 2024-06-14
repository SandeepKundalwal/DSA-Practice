public class Main {
    public static void main(String[] args) {
        int nums[] = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(nums));
    }

    public static int minIncrementForUnique(int[] nums) {
        int n = nums.length;

        int maxi = 0;
        for(int num : nums){
            maxi = Math.max(maxi, num);
        }

        int count[] = new int[maxi + n];

        for(int num : nums){
            count[num]++;
        }

        int moves = 0;
        int nextUnique = 0;
        for(int i = 0; i <= maxi;){
            if(count[i]-- > 1) {
                nextUnique = Math.max(i + 1, nextUnique);
                while(nextUnique < (maxi + n) && count[nextUnique] > 0) nextUnique++;
                moves += (nextUnique - i);
                nextUnique++;
            } else {
                i++;
            }
        }

        return moves;
    }
}