public class Main {
    public static void main(String[] args) {
        int hour = 6;
        int dist[] = {1,3,2};
        System.out.println("Minimum Speed: " + minSpeedOnTime(dist, hour));
    }

    /**
     1. Return -> Minimum Positive Integer Speed; otherwise -1
     2. To move to next higher integer -> Math.ceil((double)2 / 3)
     3. Have to use Binary Search to do it in nlogk where k is the search space; Search Space expands from 0 to 10000001
     */
    public static int minSpeedOnTime(int[] dist, double hour) {
        int left = 0;
        int right = 10000001;
        int speed = 0;

        while(left < right){
            int middle = left + ((right - left) / 2);

            double time = possibleToReachOffice(middle, dist, hour);

            if(time == hour){
                return middle;
            } else if(time > hour){
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left == 10000001 ? -1 : left;
    }

    public static double possibleToReachOffice(int speed, int[] dist, double hour){
        double time = 0;
        for(int i = 0; i < dist.length; i++){
            double timeTakenByTrain = (double)dist[i]/speed;
            if( i == dist.length - 1){
                time += timeTakenByTrain;
                break;
            }
            time += Math.ceil(timeTakenByTrain);
        }
        return time;
    }
}