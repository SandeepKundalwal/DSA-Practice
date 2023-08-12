public class Main {
    public static void main(String[] args) {
        int obstacleGrid[][] = {
                {0,0,0},{0,1,0},{0,0,0}
        };
        System.out.println("Memoization: " + Memoization.uniquePathsWithObstacles(obstacleGrid));
        System.out.println("Tabulation: " + Tabulation.uniquePathsWithObstacles(obstacleGrid));
    }
}