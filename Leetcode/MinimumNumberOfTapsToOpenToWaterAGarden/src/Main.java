public class Main {
    public static void main(String[] args) {
//        int n = 35;
//        int ranges[] = {1,0,4,0,4,1,4,3,1,1,1,2,1,4,0,3,0,3,0,3,0,5,3,0,0,1,2,1,2,4,3,0,1,0,5,2};
//        int n = 8;
//        int ranges[] = {1,0,1,0,0,2,2,0,0};
        int n = 5;
        int ranges[] = {3,4,1,1,0,0};
        System.out.println(minTaps(n, ranges));
    }

    // can be done in n^2
    static int ans1 = -1;
    public static int minTaps(int n, int[] ranges) {
        int ans1 = f(0, Integer.MAX_VALUE, Integer.MIN_VALUE, n, ranges);
        return ans1 >= Integer.MAX_VALUE? -1 : ans1;
        // return ans;
    }

    public static int f(int idx, int leftRange, int rightRange, int n, int ranges[]){
        if(leftRange == 0 && rightRange == n){
            return 0;
        }

        if(idx >= ranges.length){
            return Integer.MAX_VALUE;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = idx; i < ranges.length; i++){
            if(i - ranges[1] >= leftRange && i + ranges[i] <= rightRange){
                continue;
            }
            if(ranges[i] != 0 && ((i - ranges[i] < leftRange && leftRange != 0)|| (i + ranges[i] > rightRange && rightRange != n))){
                System.out.println(i);
                return ans = Math.min(ans, 1 + f(i + 1, i - ranges[i] < 0 ? 0 : Math.min(leftRange, i - ranges[i]) , i + ranges[i] > n ? n : Math.max(rightRange, i + ranges[i]) , n, ranges));
            }
        }

        return ans;
    }
}