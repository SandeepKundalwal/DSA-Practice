import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int roads[][] = {{0,1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        System.out.println(maximumImportance(n, roads));
    }

    public static long maximumImportance(int n, int[][] roads) {
        int indegree[] = new int[n];

        for(int road[] : roads){
            int u = road[0];
            int v = road[1];

            indegree[u]++;
            indegree[v]++;
        }

        Pair idxDegree[] = new Pair[n];
        for(int i = 0; i < n; i++){
            idxDegree[i] = new Pair(i, indegree[i], 0);
        }

        Arrays.sort(idxDegree, (a, b) -> (a.indegree - b.indegree));

        for(int i = 0; i < n; i++){
            idxDegree[i].importance = i + 1;
        }

        Arrays.sort(idxDegree, (a, b) -> (a.idx - b.idx));

        Long totalImportance = 0L;
        for(int road[] : roads){
            totalImportance += (idxDegree[road[0]].importance + idxDegree[road[1]].importance);
        }

        return totalImportance;
    }

    static class Pair{
        int idx;
        int indegree;
        int importance;

        public Pair(int idx, int indegree, int importance){
            this.idx = idx;
            this.indegree = indegree;
            this.importance = importance;
        }
    }
}