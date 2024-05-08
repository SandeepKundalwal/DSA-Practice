public class Main {
    public static void main(String[] args) {
        char grid[][] = {{'B','W','B'},{'B','W','W'},{'B','W','B'}};
        System.out.println(canMakeSquare(grid));
    }

    public static boolean canMakeSquare(char[][] grid) {
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                char first = grid[i][j];
                char second = grid[i][j + 1];
                char third = grid[i + 1][j];
                char fourth = grid[i + 1][j + 1];

                if(count(first, second, third, fourth, 'B') >= 3 || count(first, second, third, fourth, 'W') >= 3){
                    return true;
                }
            }
        }
        return false;
    }

    public static int count(char first, char second, char third, char fourth, char color){
        int count = 0;
        if(first == color){
            count++;
        }

        if(second == color){
            count++;
        }

        if(third == color){
            count++;
        }

        if(fourth == color){
            count++;
        }

        return count;
    }
}