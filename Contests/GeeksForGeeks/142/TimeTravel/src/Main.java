public class Main {
    public static void main(String[] args) {
        int n = 3;
        int arr[] = {2024,2022,2023};
        System.out.println(timeTravel(n, arr));
    }

    public static int timeTravel(int n, int[] arr) {
        // code here
        int time = 0;
        int previousYear = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] < previousYear){
                time += 2;
            } else if(arr[i] > previousYear){
                time += 1;
            }
            previousYear = arr[i];
        }
        return time;
    }
}