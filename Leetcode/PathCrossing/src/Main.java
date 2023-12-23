import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static javax.swing.UIManager.put;

public class Main {
    static Map<Character, Integer[]> directions = new HashMap<>(){{
        put('E', new Integer[]{1, 0});
        put('W', new Integer[]{-1, 0});
        put('N', new Integer[]{0, 1});
        put('S', new Integer[]{0,-1});
    }};
    public static void main(String[] args) {
        String path = "NES";
        System.out.println(isPathCrossing(path));
    }

    public static boolean isPathCrossing(String path) {
        Set<String> previousLocations = new HashSet<>();
        previousLocations.add(0 + "-" + 0);

        Integer previousLocation[] = new Integer[]{0, 0};
        for(char direction : path.toCharArray()){
            previousLocation = newPosition(previousLocation, direction);
            String newLocation = previousLocation[0] + "-" + previousLocation[1];
            if(previousLocations.contains(newLocation)){
                return true;
            }
            previousLocations.add(newLocation);
        }
        return false;
    }

    public static Integer[] newPosition(Integer previousLocation[], Character direction){
        Integer dDirections[] = directions.get(direction);
        previousLocation[0] = previousLocation[0] + dDirections[0];
        previousLocation[1] = previousLocation[1] + dDirections[1];
        return previousLocation;
    }
}