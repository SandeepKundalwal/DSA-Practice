public class Main {
    public static void main(String[] args) {
        int mat1[][] = {{1, 5, 6},
                        {8, 10, 11},
                        {15, 16, 18}};
        int mat2[][] = {{2, 4, 7},
                        {9, 10, 12},
                        {13, 16, 20}};
        int n = 3;
        int x = 21;
        System.out.println(countPairs(mat1, mat2, n, x));
    }

    static int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                int left = 0, right = n * n - 1;
                while(left <= right){
                    int mid = left + ((right - left) / 2);

                    int iM2 = mid / n;
                    int jM2 = mid % n;

                    if(mat1[i][j] + mat2[iM2][jM2] == x){
                        count++;
                        break;
                    } else if (mat1[i][j] + mat2[iM2][jM2] < x){
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return count;
    }
}