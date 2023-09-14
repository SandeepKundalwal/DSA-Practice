import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

        System.out.println(findItinerary(tickets));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> hashMap = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(!hashMap.containsKey(from)){
                hashMap.put(from, new PriorityQueue<>());
            }
            hashMap.get(from).offer(to);
        }

        List<String> itinerary = new ArrayList<>();
        DFS("JFK", hashMap, itinerary);
        return itinerary;
    }

    public static void DFS(String airport, Map<String, PriorityQueue<String>> hashMap, List<String> itinerary){
        if(hashMap.containsKey(airport)){
            while(!hashMap.get(airport).isEmpty()){
                DFS(hashMap.get(airport).remove(), hashMap, itinerary);
            }
        }

        itinerary.add(0, airport);
    }
}