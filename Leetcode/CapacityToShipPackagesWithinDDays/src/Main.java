public class Main {
    public static void main(String[] args) {
        int days = 5;
        int weights[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int totalWeight = 0;
        for(int i = 0; i < weights.length; i++){
            totalWeight += weights[i];
        }

        int ans = -1;
        int left = 0, right = totalWeight;
        while(left <= right){
            int mid = left + ((right - left) / 2);

            if(possible(mid, weights) <= days){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static int possible(int weight, int weights[]){
        int days = 0;
        int currentWeight = 0;
        for(int i = 0; i < weights.length; i++){
            if(weight < weights[i]) return Integer.MAX_VALUE;

            currentWeight += weights[i];
            if(currentWeight > weight){
                days++;
                currentWeight = weights[i];
            }
        }

        return days + 1;
    }
}