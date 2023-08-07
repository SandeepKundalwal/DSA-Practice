public class PureBinarySearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n;

        while(left < right){
            int mid = left + ((right - left) / 2);
            // System.out.println(mid + " " + (mid / n) + " " + (mid % n));
            int midValue = matrix[mid / n][mid % n];

            if(midValue == target){
                return true;
            } else if(midValue < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return false;
    }
}
