import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        String names[] = {"Mary","John","Emma"};
        int heights[] = {180,165,170};
        System.out.println(Arrays.toString(sortPeople(names, heights)));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<People> pq = new PriorityQueue<>((a, b) -> b.height - a.height);

        for(int i = 0; i < names.length; i++){
            pq.offer(new People(heights[i], names[i]));
        }

        int i = 0;
        while(!pq.isEmpty()){
            names[i++] = pq.poll().name;
        }

        return names;
    }

    static class People{
        int height;
        String name;

        public People(int height, String name){
            this.height = height;
            this.name = name;
        }
    }
}