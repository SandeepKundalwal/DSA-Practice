public class Main {
    public static void main(String[] args) {
        int k = 3;
        int tickets[] = {84,49,5,24,70,77,87,8};
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int totalTime = 0;
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i] < tickets[k]){
                totalTime += tickets[i];
            } else {
                if(i <= k){
                    totalTime += tickets[k];
                } else {
                    totalTime += (tickets[k] - 1);
                }

            }
        }

        return totalTime;
    }
}