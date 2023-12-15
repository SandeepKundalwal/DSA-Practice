import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<List<String>> paths = List.of(
                List.of("London","New York"),
                List.of("New York","Lima"),
                List.of("Lima","Sao Paulo")
        );
        System.out.println(destCity(paths));
    }

    public static String destCity(List<List<String>> paths) {
        Map<String, List<String>> graph = new HashMap<>();
        for(List<String> path : paths){
            String src = path.get(0);
            String des = path.get(1);
            if(!graph.containsKey(src)){
                graph.put(src, new ArrayList<>());
            }

            if(!graph.containsKey(des)){
                graph.put(des, new ArrayList<>());
            }

            graph.get(src).add(des);
        }

        for(Map.Entry<String, List<String>> it : graph.entrySet()){
            if(it.getValue().isEmpty()){
                return it.getKey();
            }
        }

        // should never reach here
        return new String();
    }
}