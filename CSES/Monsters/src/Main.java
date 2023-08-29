import java.util.*;

public class Main {
    private static int directions[][] = {
            {-1, 0},{0, 1},{1, 0},{0, -1}
    };
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        if(n == 1 && m == 1){
            System.out.println("YES");
            System.out.println(0);
            return;
        }

        char labyrinth[][] = new char[n][m];
        for(int i = 0; i < n; i++){
            labyrinth[i] = in.next().toCharArray();
        }

        canReachBoundary(n, m, labyrinth);
    }

    public static void canReachBoundary(int n, int m, char labyrinth[][]){
        int iA = -1;
        int jA = -1;
        int timedLabyrinth[][] = new int[n][m];
        Queue<Position> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(labyrinth[i][j] == 'A'){
                    iA = i;
                    jA = j;
                    timedLabyrinth[i][j] = Integer.MAX_VALUE;
                } else if(labyrinth[i][j] == 'M'){
                    timedLabyrinth[i][j] = 0;
                    queue.offer(new Position(i, j));
                } else {
                    timedLabyrinth[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        if(iA == 0 || iA == n - 1 || jA == 0 || jA == m - 1){
            System.out.println("YES");
            System.out.println(0);
            return;
        }

        int timer = 0;
        while(!queue.isEmpty()){
            timer++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Position position = queue.remove();
                int monsterI = position.i;
                int monsterJ = position.j;

                for(int direction[] : directions){
                    int dMonsterI = monsterI + direction[0];
                    int dMonsterJ = monsterJ + direction[1];

                    if(isValid(dMonsterI, dMonsterJ, n, m) && labyrinth[dMonsterI][dMonsterJ] != '#' && timer < timedLabyrinth[dMonsterI][dMonsterJ]){
                        timedLabyrinth[dMonsterI][dMonsterJ] = timer;
                        queue.offer(new Position(dMonsterI, dMonsterJ));
                    }
                }
            }
        }

        timer = 0;
        queue.offer(new Position(iA, jA));
        while(!queue.isEmpty()){
            timer++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Position position = queue.remove();
                int posI = position.i;
                int posJ = position.j;

                for(int direction[] : directions){
                    int dPosI = posI + direction[0];
                    int dPosJ = posJ + direction[1];

                    if(isValid(dPosI, dPosJ, n, m) && labyrinth[dPosI][dPosJ] != '#' && timer < timedLabyrinth[dPosI][dPosJ]){
                        timedLabyrinth[dPosI][dPosJ] = timer;
                        queue.offer(new Position(dPosI, dPosJ));
                        if(dPosI == 0 || dPosI == n - 1 || dPosJ == 0 || dPosJ == m - 1){
                            System.out.println("YES");
                            runPathBFS(dPosI, dPosJ, iA, jA, n, m, timedLabyrinth);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("NO");
    }

    private static void runPathBFS(int i, int j, int iA, int jA, int n, int m, int timedLabyrinth[][]){
        boolean visited[][] = new boolean[n][m];
        StringBuilder currPath = new StringBuilder();
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(i, j));

        while(!queue.isEmpty()){
            int size = queue.size();
            for(; size > 0; size--){
                Position position = queue.remove();
                int I = position.i;
                int J = position.j;
                visited[I][J] = true;

                for(int k = 0; k < 4; k++){
                    int dI = I + directions[k][0];
                    int dJ = J + directions[k][1];

                    if(isValid(dI, dJ, n, m) && !visited[dI][dJ] && (timedLabyrinth[I][J] == timedLabyrinth[dI][dJ] + 1 || (dI == iA && dJ == jA))){
                        currPath.append(k == 0 ? 'D' : k == 1 ? 'L' : k == 2 ? 'U' : 'R');
                        if((dI == iA && dJ == jA)){
                            System.out.println(currPath.length());
                            System.out.println(currPath.reverse());
                            return;
                        }
                        queue.offer(new Position(dI, dJ));
                        break;
                    }
                }
            }
        }
    }

    /**
     * Will lead to StackOverflow as the recursion will be too deep
     */
    public static void runDFS(int i, int j, int iA, int jA, int n, int m, StringBuilder currPath, int timedLabyrinth[][]){
        System.out.println(i + " " + j);
        for(int k = 0; k < 4; k++){
            int dI = i + directions[k][0];
            int dJ = j + directions[k][1];

            if(isValid(dI, dJ, n, m) && timedLabyrinth[i][j] == timedLabyrinth[dI][dJ] + 1){
                currPath.append(k == 0 ? 'D' : k == 1 ? 'L' : k == 2 ? 'U' : 'R');
                if((dI == iA && dJ == jA)){
                    System.out.println(currPath.length());
                    System.out.println(currPath.reverse());
                    return;
                }
                runDFS(dI, dJ, iA, jA, n, m, currPath, timedLabyrinth);
                currPath.deleteCharAt(currPath.length() - 1);
            }
        }
    }

    private static boolean isValid(int i, int j, int n, int m){
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    static class Position{
        int i;
        int j;

        public Position(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}