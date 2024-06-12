public class Main {
    public static void main(String[] args) {
        int seats[] = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        int n = seats.length;

        int maxi = 0;
        int left = 0, right = 0;
        for(int i = 0; i < n; i++){
            if(seats[i] == 0){
                if(i <= left || i >= right){
                    left = i - 1;
                    right = i + 1;

                    while(left >= 0 && seats[left] == 0) left--;

                    while(right < n && seats[right] == 0) right++;

                    if(left < 0) left = Integer.MAX_VALUE;

                    if(right >= n) right = Integer.MAX_VALUE;
                }

                maxi = Math.max(maxi, Math.min(Math.abs(i - left), right - i));
            }
        }

        return maxi;
    }
}