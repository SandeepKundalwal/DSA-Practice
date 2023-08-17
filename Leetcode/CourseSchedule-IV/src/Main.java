public class Main {
    public static void main(String[] args) {
        int numCourses = 3;
        int prerequisites[][] = {{1,2},{1,0},{2,0}};
        int queries[][] = {{1,0},{1,2}};
        System.out.println("DFS: " + DFS.checkIfPrerequisite(numCourses, prerequisites, queries));
    }
}