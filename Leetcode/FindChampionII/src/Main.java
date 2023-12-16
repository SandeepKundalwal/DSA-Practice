public class Main {
    public static void main(String[] args) {
        int n = 3;
        int edges[][] = {
                {0,1},
                {1,2}
        };
        System.out.println(findChampion(n, edges));
    }

    public static int findChampion(int n, int[][] edges) {
        int indegree[] = new int[n];
        for(int edge[] : edges){
            int src = edge[0];
            int des = edge[1];
            indegree[des]++;
        }

        int champion = -1;
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                if(champion != -1){
                    return -1;
                } else {
                    champion = i;
                }
            }
        }

        return champion;
    }
}