import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int roads[][] = {{0,1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        System.out.println(maximumImportance(n, roads));
    }

    public static long maximumImportance(int n, int[][] roads) {
        long degree[] = new long[n];
        for(int road[] : roads){
            int u = road[0];
            int v = road[1];

            degree[u]++;
            degree[v]++;
        }

        Arrays.sort(degree);

        Long totalImportance = 0L;
        for(int i = 0; i < n; i++){
            totalImportance += (degree[i] * (i + 1));
        }

        return totalImportance;
    }
}