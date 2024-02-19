import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        System.out.println("Linear Space: " + findTheWinnerLinearSpace(n, k));
        System.out.println("Constant Space: " + (findTheWinner(n , k) + 1));
    }

    static int findTheWinner(int n, int k){
        if(n == 1){
            return 0;
        }

        return (findTheWinner(n - 1, k) + k) % n;
    }

    // Linear Space
    public static int findTheWinnerLinearSpace(int n, int k) {
        List<Integer> friends = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            friends.add(i);
        }

        return fLinearSpace(friends, 0, k);
    }

    public static int fLinearSpace(List<Integer> friends, int start, int k){
        if(friends.size() == 1){
            return friends.get(0);
        }

        start = (start + (k - 1)) % friends.size();
        friends.remove(start);
        return fLinearSpace(friends, start, k);
    }
}