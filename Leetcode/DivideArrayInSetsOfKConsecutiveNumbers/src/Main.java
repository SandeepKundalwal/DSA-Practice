import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3,3,4,4,5,6};
        int k = 4;
        System.out.println(isPossibleDivide(nums, k));
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;

        if(n % k != 0){
            return false;
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int num : nums){
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }

        while(!treeMap.isEmpty()){
            int start = treeMap.firstKey();

            for(int idx = start; idx < start + k; idx++){
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