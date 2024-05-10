public class Main {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        System.out.println(largestTimeFromDigits(arr));
    }

    public static String largestTimeFromDigits(int[] arr) {
        String time[] = {""};
        f(0, arr, time);
        return time[0];
    }

    public static void f(int idx, int arr[], String time[]){
        if(idx >= 4){
            String currHours = arr[0] + "" + arr[1];
            String currMinutes =  arr[2] + "" + arr[3];

            if(Integer.parseInt(currHours) < 24 && Integer.parseInt(currMinutes) < 60){
                if(time[0].isEmpty()){
                    time[0] = currHours + ":" + currMinutes;
                } else {
                    int prevHours = Integer.parseInt(time[0].substring(0, 2));
                    int prevMinutes = Integer.parseInt(time[0].substring(3, 5));

                    if(prevHours < Integer.parseInt(currHours) || (prevHours == Integer.parseInt(currHours) && prevMinutes < Integer.parseInt(currMinutes))){
                        time[0] = currHours + ":" + currMinutes;
                    }
                }
            }

            return;
        }


        for(int i = idx; i < 4; i++){
            swap(i, idx, arr);
            f(idx + 1, arr, time);
            swap(i, idx, arr);
        }
    }

    public static void swap(int i, int j, int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}