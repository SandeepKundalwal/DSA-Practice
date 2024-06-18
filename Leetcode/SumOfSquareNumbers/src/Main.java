import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int c = 2147483647;
        System.out.println(judgeSquareSum(c));
    }

    public static boolean judgeSquareSum(int c) {
        if(c <= 2) return true;

        long a = 0, b = (long)Math.sqrt(c);
        while(a <= b){
            long squaredSum = (a * a) + (b * b);

            if(squaredSum == c) return true;
            else if(squaredSum < c) a++;
            else b--;
        }
        return false;
    }

    public static boolean judgeSquareSumExtraSpace(int c) {
        if(c <= 2) return true;

        Set<Integer> set = new HashSet<>();

        set.add(0);

        int sqrtC = (int)Math.sqrt(c);
        for(int i = 1; i <= sqrtC; i++){
            int squared = i * i;
            if((squared + squared) == c || set.contains(c - (squared))){
                return true;
            }
            set.add(squared);
        }

        return false;
    }
}