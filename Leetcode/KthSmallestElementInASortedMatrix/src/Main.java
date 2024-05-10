public class Main {
    public static void main(String[] args) {
        int matrix[][] = {{1,2},{1,3}};
        int k = 2;
        System.out.println(kthSmallest(matrix, k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];

        int ans = -1;
        while(left <= right){
            int midNo = left + ((right - left) >> 1);

            int count = findCountOfSmallerElement(midNo, matrix);

            if(count >= k){
                ans = midNo;
                right = midNo - 1;
            } else{
                left = midNo + 1;
            }
        }

        return ans;
    }

    public static int findCountOfSmallerElement(int midNo, int matrix[][]){
        int n = matrix.length;

        int count = 0;
        for(int i = 0; i < n; i++){
            if(matrix[i][0] <= midNo){
                if(matrix[i][n - 1] <= midNo){
                    count += n;
                } else{
                    // binary search
                    int left = 0, right = n - 1;

                    int ans = 0;
                    while(left <= right){
                        int mid = left + ((right - left) >> 1);

                        if(matrix[i][mid] <= midNo){
                            ans = mid;
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }

                    count += (ans + 1);
                }

            }
        }

        return count;
    }
}