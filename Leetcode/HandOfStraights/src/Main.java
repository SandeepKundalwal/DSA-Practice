import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        int hand[] = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0){
            return false;
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int h : hand){
            treeMap.put(h, treeMap.getOrDefault(h, 0) + 1);
        }

        while(!treeMap.isEmpty()){
            int start = treeMap.firstKey();

            for(int idx = start; idx < start + groupSize; idx++){
                if(!treeMap.containsKey(idx)){
                    return false;
                } else {
                    if(treeMap.get(idx) == 1){
                        treeMap.remove(idx);
                    } else {
                        treeMap.put(idx, treeMap.get(idx) - 1);
                    }
                }
            }
        }

        return true;
    }
}