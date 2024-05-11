public class Main {
    public static void main(String[] args) {
        int tops[] = {1,1,2,2};
        int bottoms[] = {2,1,1,1};
        System.out.println(minDominoRotations(tops, bottoms));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int mini = Math.min(possibleWays(tops[0], tops, bottoms), possibleWays(bottoms[0], tops, bottoms));
        mini = Math.min(mini, possibleWays(tops[0], bottoms, tops));
        mini = Math.min(mini, possibleWays(bottoms[0], bottoms, tops));

        return mini == Integer.MAX_VALUE ? -1 : mini;
    }

    public static int possibleWays(int val, int A[], int B[]){
        int swaps = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != val && B[i] != val){
                return Integer.MAX_VALUE;
            }

            if(A[i] != val){
                swaps++;
            }
        }
        return swaps;
    }
}