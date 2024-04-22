import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1));
        rooms.add(List.of(2));
        rooms.add(List.of(3));
        rooms.add(new ArrayList<>());
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean visited[] = new boolean[n];

        f(0, rooms, visited);

        for(boolean room : visited){
            if(!room) return false;
        }
        return true;
    }

    public static void f(int src, List<List<Integer>> rooms, boolean visited[]){
        visited[src] = true;

        for(Integer keys : rooms.get(src)){
            if(!visited[keys]){
                f(keys, rooms, visited);
            }
        }
    }
}