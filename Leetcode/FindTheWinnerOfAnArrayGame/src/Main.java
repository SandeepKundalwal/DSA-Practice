public class Main {
    public static void main(String[] args) {
        int arr[] = {18,15,20};
        int k = 2;
        System.out.println(getWinner(arr, k));
    }

    public static int getWinner(int[] arr, int k) {
        int n = arr.length;

        int maxi = arr[0];
        int consecutiveWins = 0;
        for(int i = 1; i < n; i++){
            if(maxi >= arr[i]){
                consecutiveWins++;
            } else {
                maxi = arr[i];
                consecutiveWins = 1;
            }

            if(consecutiveWins >= k) break;
        }

        return maxi;
    }
}