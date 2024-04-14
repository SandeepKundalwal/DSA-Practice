public class Main {
    public static void main(String[] args) {
        int coins[] = {16,7,10,15,18,8,13,14,9};
        int k = 82425;
        System.out.println(findKthSmallest(coins, k));
    }

    public static long findKthSmallest(int[] coins, int k) {
        long ans = 0;
        long left = 1, right = 25 + (2 * 25 * (long)(1e9));
        while(left <= right){
            long mid = left + ((right - left) / 2);

            long count = findCount(coins, mid);

            if(count >= k){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static long findCount(int coins[], long x){
        int m = coins.length;
        int allOnes = (1 << m) - 1;

        long count = 0;

        for(int mask = 1; mask <= allOnes; mask++){
            long setBitsLCM = 1;
            for(int j = 0; j < m; j++){
                if((mask & (1 << j)) != 0){
                    setBitsLCM = findLCM(setBitsLCM, coins[j]);
                }
            }

            int setBits = countSetBits(mask);
            if((countSetBits(mask) & 1) == 0){
                count -= (x / setBitsLCM);
            } else {
                count += (x / setBitsLCM);
            }
        }

        return count;
    }

    public static long findLCM(long a, long b){
        return (a * b) / findGCD(a, b);
    }

    public static long findGCD(long a, long b){
        if(b == 0){
            return a;
        }

        return (long)findGCD(b, a % b);
    }

    public static int countSetBits(int mask){
        int setBits = 0;
        for(int bit = 0; bit < 32; bit++){
            if((mask & (1 << bit)) != 0){
                setBits++;
            }
        }

        return setBits;
    }
}