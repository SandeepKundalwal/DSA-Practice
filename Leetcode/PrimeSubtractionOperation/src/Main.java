import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        int nums[] = {4,9,6,10};
        System.out.println(primeSubOperation(nums));
    }

    public static boolean primeSubOperation(int[] nums) {
        int maxi = Arrays.stream(nums).max().getAsInt();
        boolean primes[] = sieve(maxi);

        for(int i = 0; i < nums.length; i++){
            int lowerPrime = findLowerPrime(i, nums, primes);
            if(lowerPrime != -1){
                nums[i] = nums[i] - lowerPrime;
            }

            if(i != 0 && nums[i - 1] >= nums[i]){
                return false;
            }
        }

        return true;
    }

    public static int findLowerPrime(int idx, int nums[], boolean primes[]){
        int start = nums[idx];

        for(int i = start - 1; i > 1; i--){
            if(primes[i]){
                int nearestLowerPrime = start - i;
                if(idx == 0 || nums[idx - 1] < nearestLowerPrime){
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean[] sieve(int n){
        boolean primes[] = new boolean[n + 1];
        Arrays.fill(primes, true);
        for(int i = 2; i * i <= n; i++){
            if(primes[i]){
                for(int j = i * i; j <= n; j += i){
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}