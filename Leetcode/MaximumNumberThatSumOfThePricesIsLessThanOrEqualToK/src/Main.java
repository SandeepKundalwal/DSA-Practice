public class Main {
    public static void main(String[] args) {
        long k = 9;
        int x = 2;
        System.out.println(findMaximumNumber(k,x));
    }

    public static long findMaximumNumber(long k, int x) {
        long left = 0, right = (long) 1e15;

        long ans = 0;
        while(left <= right){
            long mid = left + ((right - left) / 2);

            long bitSum[] = new long[64];
            findSetBits(mid, bitSum);

            long setBits = 0;
            for(int i = 0; i < 54; i++){
                if((i + 1) % x == 0){
                    setBits += bitSum[i];
                }
            }

            if(setBits <= k){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void findSetBits(long n, long bitSum[]){
        if(n == 0) return;

        if(n == 1){
            bitSum[0]++;
            return;
        }

        if(n == 2){
            bitSum[0]++;
            bitSum[1]++;
            return;
        }

        int msb = (int) (Math.log(n) / Math.log(2));
        long power = ((long) 1 << msb);
        bitSum[msb] += (long) (n - power + 1);

        for(int i = 0; i < msb; i++){
            bitSum[i] += (power / 2);
        }

        n = n - power;
        findSetBits(n, bitSum);
    }
}