import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int directions[][] = {
            {0, -1}, {-1, 0}, {0, 1}, {1, 0}
    };
    public static void main(String[] args) {
        char grid2[][] = {
                {'#','#','#','#','#','#','#','#'},
                {'#','M','.','.','A','.','.','#'},
                {'#','.','#','.','M','#','.','#'},
                {'#','M','#','.','.','#','.','.'},
                {'#','.','#','#','#','#','#','#'}
        };

        char grid1[][] = {
                {'#','#','#','#','#','#','#','#'},
                {'#','.','.','.','.','.','A','#'},
                {'#','.','#','#','#','#','#','#'},
                {'#','.','.','.','.','.','.','#'},
                {'#','.','#','#','#','#','.','#'},
                {'#','.','.','.','.','#','.','#'},
                {'#','.','#','#','.','#','.','#'},
                {'#','.','#','M','.','#','.','#'}
        };

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int Ai = 0, Aj = 0;
        List<int []> monsters = new ArrayList<>();
        char grid[][] = new char[n][m];
        for(int i = 0; i < n; i++){
            String row = in.next();
            for(int j = 0; j < m; j++){
                char character = row.charAt(j);
                if(character == 'A'){
                    Ai = i;
                    Aj = j;
                } else if(character == 'M'){
                    monsters.add(new int[]{i, j});
                }
                grid[i][j] = character;
            }
        }

        Instant start = Instant.now();
        boolean ans = canReachOutside(Ai, Aj, monsters, n, m, grid);
        if(!ans){
            System.out.println("NO");
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: " + timeElapsed.toSeconds() + " seconds");
    }

    static StringBuilder path = new StringBuilder();
    public static boolean canReachOutside(int Ai, int Aj, List<int []> monsters, int row, int col, char grid[][]){
        if(Ai == 0 || Ai == row - 1 || Aj == 0 || Aj == col - 1){
            System.out.println("YES");
            System.out.println(path.length());
            System.out.println(path);
            return true;
        }

        for(int k = 0; k < 4; k++){
            int dAi = Ai + directions[k][0];
            int dAj = Aj + directions[k][1];

            char newGrid[][] = makeNewGrid(row, col, grid);

            if(grid[dAi][dAj] != '#' && grid[dAi][dAj] != 'M'){
                path.append(k == 0 ? 'L' : k == 1 ? 'U' : k == 2 ? 'R' : 'D');
                newGrid[dAi][dAj] = 'A';

                List<int []> newMonsters = new ArrayList<>();
                for(int monster[] : monsters){
                    for(int mDirection[] : directions){
                        int dMi = monster[0] + mDirection[0];
                        int dMj = monster[1] + mDirection[1];

                        if(dMi >= 0 && dMi < row && dMj >= 0 && dMj < col && grid[dMi][dMj] != '#' && grid[dMi][dMj] != 'M' && newGrid[dMi][dMj] != 'M'){
                            newGrid[dMi][dMj] = 'M';
                            newMonsters.add(new int[]{dMi, dMj});
                        }
                    }
                }

                boolean isPossible = canReachOutside(dAi, dAj, newMonsters, row, col, newGrid);
                path.deleteCharAt(path.length() - 1);

                if(isPossible){
                    return true;
                }
            }
        }
        return false;
    }

    public static char[][] makeNewGrid(int row, int col, char[][] grid){
        char[][] newGrid = new char[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                newGrid[i][j] = grid[i][j];
            }
        }

        return newGrid;
    }
}