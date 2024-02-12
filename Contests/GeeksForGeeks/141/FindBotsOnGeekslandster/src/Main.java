import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        String usernames[] = {"foo","bab"};
        System.out.println(Arrays.toString(findBots(usernames, n)));
    }

    public static int[] findBots(String usernames[], int n){
        // Code Here.
        int ans[] = new int[n];
        for(int i = 0; i < n; i++){
            String username = usernames[i];

            int countEvenPositions = 0;
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < username.length(); j++){
                if(j % 2 == 0){
                    char c = username.charAt(j);
                    if(!set.contains(c)){
                        set.add(c);
                        countEvenPositions++;
                    }
                }
            }

            if(isPrime(countEvenPositions)){
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }

    public static boolean isPrime(int no){
        if(no == 1) return false;

        for(int i = 2; i < no; i++){
            if(no % i == 0){
                return false;
            }
        }
        return true;
    }
}