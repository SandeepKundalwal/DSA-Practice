import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int groupSizes[] = {3,3,3,3,3,1,3};
        System.out.println(groupThePeople(groupSizes));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> groups = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            int groupSize = groupSizes[i];
            if(!groupMap.containsKey(groupSize)){
                groupMap.put(groupSize, new ArrayList<>());
            }
            groupMap.get(groupSize).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> it : groupMap.entrySet()){
            int groupSize = it.getKey();
            int numElements = it.getValue().size();
            List<Integer> elements = it.getValue();

            for(int i = 0; i < numElements;){
                List<Integer> group = new ArrayList<>();
                for(int j = 0; j < groupSize; j++){
                    group.add(elements.get(i++));
                }
                groups.add(group);
            }
        }
        return groups;
    }
}