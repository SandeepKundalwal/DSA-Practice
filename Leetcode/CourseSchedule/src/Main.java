import java.util.*;

public class Main {
    public static void main(String[] args) {
        int numCourses = 2;
        int prerequisites[][] = new int[][]{
                {1,0}, {0,1}
        };
        System.out.println(canFinish(numCourses, prerequisites));
    }

    // Topological Sort
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0){
            return true;
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            adjList.put(i, new ArrayList<>());
        }

        int indegree[] = new int[numCourses];
        for(int[] dependency : prerequisites){
            adjList.get(dependency[1]).add(dependency[0]);
            indegree[dependency[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int coursesPossible = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            coursesPossible++;

            for(int course : adjList.get(node)){
                indegree[course]--;
                if(indegree[course] == 0){
                    queue.offer(course);
                }
            }
        }

        return coursesPossible == numCourses;
    }
}