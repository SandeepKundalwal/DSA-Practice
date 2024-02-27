public class Main {
    public static void main(String[] args) {
        int bottomLeft[][] = {{1,1},{2,2},{3,1}};
        int topRight[][] = {{3,3},{4,4},{6,6}};
        System.out.println(largestSquareArea(bottomLeft, topRight));
    }

    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;

        long area = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int minX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int maxX = Math.min(topRight[i][0], topRight[j][0]);
                int minY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int maxY = Math.min(topRight[i][1], topRight[j][1]);

                if(minX < maxX && minY < maxY){
                    long side = Math.min(maxX - minX, maxY - minY);
                    area = Math.max(area, side * side);
                }
            }
        }
        return area;
    }
}