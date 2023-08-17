import java.util.*;

public class Main {
    public static void main(String[] args) {
        int numCourse = 4;
        int prerequisistes[][] = {
                {1,0}, {2,0}, {3,1}, {3,2}
        };
        System.out.println(Arrays.toString(findOrder(numCourse, prerequisistes)));
    }

    // find using topological sort.!
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }

        int inDegree[] = new int[numCourses];
        for(int prerequisite[] : prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int index = 0;
        int coursesPossible = 0;
        int order[] = new int[numCourses];
        while(!queue.isEmpty()){
            int node = queue.poll();
            coursesPossible++;
            order[index++] = node;

            for(int neighbour : graph.get(node)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }

        return coursesPossible == numCourses ? order : new int[0];
    }
}