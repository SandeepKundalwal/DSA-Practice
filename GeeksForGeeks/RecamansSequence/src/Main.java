import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(recamanSequence(145));
    }

    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> recamanSequence = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        recamanSequence.add(0);
        hashSet.add(0);

        for(int i = 1; i < n; i++){
            int nextNo = recamanSequence.get(i - 1) - i;
            if(nextNo < 0 || hashSet.contains(nextNo)){
                nextNo = recamanSequence.get(i - 1) + i;
            }
            hashSet.add(nextNo);
            recamanSequence.add(nextNo);
        }

        return recamanSequence;
    }
}