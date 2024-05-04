import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int people[] = {5,1,4,2};
        int limit = 6;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boats = 0;
        int left = 0, right = people.length - 1;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }

            boats++;
            right--;
        }

        return boats;
    }
}