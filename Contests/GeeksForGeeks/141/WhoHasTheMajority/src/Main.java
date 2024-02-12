import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 11;
        int arr[] = {1,1,2,2,3,3,4,4,4,4,5};
        int x = 4;
        int y = 5;
        System.out.println(majorityWins(arr, n, x, y));
    }

    // Function to find element with more appearances between two elements in an
    // array.
    public static int majorityWins(int arr[], int n, int x, int y) {
        // code here
        Arrays.sort(arr);

        int countX = 0;
        int countY = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] == x){
                countX++;
            } else if(arr[i] == y){
                countY++;
            }
        }

        return countX == countY ? Math.min(x, y) : countX > countY ? x : y;
    }
}