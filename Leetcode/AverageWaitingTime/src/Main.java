public class Main {
    public static void main(String[] args) {
        int customers[][] = {
                {5, 2}, {5, 4}, {10, 3}, {20, 1}
        };
        System.out.println(averageWaitingTime(customers));
    }

    public static double averageWaitingTime(int[][] customers) {
        long currTime = 0;
        double waitTime = 0.0;
        for(int customer[] : customers){
            int customerArrival = customer[0];
            int preperationTime = customer[1];

            currTime = (currTime <= customerArrival) ? customerArrival + preperationTime : currTime + preperationTime;

            waitTime += (currTime - customerArrival);
        }

        return waitTime / customers.length;
    }
}