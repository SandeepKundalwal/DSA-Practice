public class Main {
    public static void main(String[] args) {
        int dimensions[][] = {{9,3},{8,6}};
        System.out.println(areaOfMaxDiagonal(dimensions));
    }

    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxDiagonal = 0;

        for(int dimension[] : dimensions){
            int length = dimension[0];
            int width = dimension[1];
            int area = length * width;
            int diagonal = (length * length) + (width * width);

            if(diagonal > maxDiagonal){
                maxArea = area;
                maxDiagonal = diagonal;
            } else if(diagonal == maxDiagonal){
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}