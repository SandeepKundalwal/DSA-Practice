import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int candyType[] = {1,1,2,2,3,3};
        System.out.println(distributeCandies(candyType));
    }

    public static int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int candiesAliceCanEat = n >> 1;

        Set<Integer> frequencySet = new HashSet<>();
        for(int candy : candyType){
            frequencySet.add(candy);
        }

        return Math.min(candiesAliceCanEat, frequencySet.size());
    }
}