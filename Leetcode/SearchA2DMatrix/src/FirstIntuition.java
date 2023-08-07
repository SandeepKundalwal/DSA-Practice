public class FirstIntuition {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length * matrix[0].length;

        int iIndex = 0, jIndex = 0;

        while(low <= high){
            int mid = low + ((high - low) >> 1); //to avoid integer overflow
            int[] position = findRow(mid, matrix[0].length);
            iIndex = position[0];
            jIndex = position[1];

            if(matrix[iIndex][jIndex] == target){
                return true;
            } else if(matrix[iIndex][jIndex] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static int[] findRow(int index, int colLength){
        int row = 0;
        while(index > colLength){
            index -= colLength;
            row++;
        }

        int[] position = new int[2];
        position[0] = row;
        position[1] = ((index - 1 < 0) ? index : index - 1);
        return position;
    }
}
