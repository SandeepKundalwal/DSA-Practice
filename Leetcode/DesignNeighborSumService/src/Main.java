public class Main {
    public static void main(String[] args) {
        int grid[][] = {{0,1,2},{3,4,5},{6,7,8}};
        neighborSum nS = new neighborSum(grid);
        System.out.println(nS.adjacentSum(1));
        System.out.println(nS.diagonalSum(4));
        System.out.println(nS.adjacentSum(4));
        System.out.println(nS.diagonalSum(8));
    }
}