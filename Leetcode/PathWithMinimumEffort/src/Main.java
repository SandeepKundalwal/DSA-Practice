import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int heights[][] = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };
        System.out.println(minimumEffortPath(heights));
    }

    static class NODE{
        int i;
        int j;
        int effort;
        public NODE(int i, int j, int effort){
            this.i = i;
            this.j = j;
            this.effort = effort;
        }
    }

    static int directions[][] = {
            {-1,0},{0,1},{1,0},{0,-1}
    };
    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int DISTANCE[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                DISTANCE[i][j] = Integer.MAX_VALUE;
            }
        }
        DISTANCE[0][0] = 0;

        PriorityQueue<NODE> priorityQueue = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        priorityQueue.offer(new NODE(0,0,0));

        while(!priorityQueue.isEmpty()){
            NODE node = priorityQueue.remove();
            int i = node.i;
            int j = node.j;
            int effort = node.effort;

            if(effort > DISTANCE[i][j]){
                continue;
            }

            if(i == m - 1 && j == n - 1){
                return effort;
            }

            for(int direction[] : directions){
                int dI = i + direction[0];
                int dJ = j + direction[1];

                if(isValid(dI, dJ, m, n)){
                    int newEffort = Math.max(effort, Math.abs(heights[i][j] - heights[dI][dJ]));
                    if(newEffort < DISTANCE[dI][dJ]){
                        DISTANCE[dI][dJ] = newEffort;
                        priorityQueue.offer(new NODE(dI, dJ, newEffort));
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}