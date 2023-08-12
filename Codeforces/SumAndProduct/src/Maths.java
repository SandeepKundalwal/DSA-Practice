import java.util.Map;

public class Maths {
    public static long findPairs(long x, long y, int n, int a[], Map<Integer, Integer> frequencyMap){
        long cnt = 0;

        long z = x * x - 4 * y;
        if(z < 0){
            return cnt;
        }

        long sqrtZ = (long) Math.sqrt(z);
        if(sqrtZ * sqrtZ != z){
            return cnt;
        }

        int firstNumber = (int) (x + sqrtZ) / 2;
        int secondNumber = (int) (x - sqrtZ) / 2;

        if(firstNumber + secondNumber != x || firstNumber - secondNumber != sqrtZ){
            return cnt;
        }

        if(!frequencyMap.containsKey(firstNumber) || !frequencyMap.containsKey(secondNumber)){
            return cnt;
        }

        if(firstNumber == secondNumber){
            cnt = (((long) frequencyMap.get(firstNumber) * (frequencyMap.get(firstNumber) - 1)) / 2);
        } else {
            cnt = ((long) frequencyMap.get(firstNumber) * frequencyMap.get(secondNumber));
        }

        return cnt;
    }
}
