import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Main {
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        int n = 14;
        System.out.println(grayCode(n));
    }

    public static List<Integer> grayCode(int n) {
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(){
            {add(0);}
        };
        f(0, n, (int) Math.pow(2, n) - 1, hashSet);
        return result;
    }

    public static void f(int currentInteger, int n, int range, LinkedHashSet<Integer> hashSet){
        if(hashSet.size() == range + 1){
            result = new ArrayList<>(hashSet);
            return;
        }

        if(!result.isEmpty()){
            return;
        }

        for(int i = 0; i < n; i++){
            int nextInteger = flipBit(currentInteger, i);
            if(nextInteger == 0) return;
            if(!hashSet.contains(nextInteger)){
                hashSet.add(nextInteger);
                f(nextInteger, n, range, hashSet);
                hashSet.remove(nextInteger);
            }
        }
    }

    public static int flipBit(int currentInteger, int i){
        return (currentInteger ^ (1 << i));
    }
}