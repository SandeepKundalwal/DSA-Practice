public class Main {
    public static void main(String[] args) {
        int n = 2;
        int batteries[] = {3, 3, 3};
        System.out.println("Maximum Running Time: " + maxRunTime(n, batteries));
    }

    public static long maxRunTime(int n, int[] batteries) {
        long totalBattery = 0;
        for(int battery : batteries){
            totalBattery += battery;
        }

        long maxRunningTime = 0;
        long start = 0, end = totalBattery;

        while(start <= end){
            long avgTime = start + ((end - start) /2);

            if(possibleToRunAllComputers(n, batteries, avgTime)){
                maxRunningTime = avgTime;
                start = avgTime + 1;
            } else {
                end = avgTime - 1;
            }
        }

        return maxRunningTime;
    }

    public static boolean possibleToRunAllComputers(int n, int[] batteries, long avgTime){
        long totalDuration = 0;
        for(int battery : batteries){
            if(battery < avgTime){
                totalDuration += battery;
            } else {
                totalDuration += avgTime;
            }
        }

        return totalDuration >= n * avgTime;
    }
}