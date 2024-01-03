public class Main {
    public static void main(String[] args) {
        String colors = "aaba";
        int neededTime[] = {1,2,3,4};
        System.out.println(minCost(colors, neededTime));
    }

    public static int minCost(String colors, int[] neededTime) {
        int minCost = 0;
        for(int i = 0; i < neededTime.length - 1;){
            if(colors.charAt(i) == colors.charAt(i + 1)){
                int pair[] = findTime(i, colors, neededTime);
                i = pair[0];
                minCost += pair[1];
            } else {
                i++;
            }
        }
        return minCost;
    }

    public static int[] findTime(int i, String colors, int neededTime[]){
        // leave the balloon with max neededTime
        int j = i + 1;
        int time = 0;
        int maxValue = neededTime[i];
        while(j < neededTime.length && colors.charAt(i) == colors.charAt(j)){
            if(maxValue < neededTime[j]){
                time += maxValue;
                maxValue = neededTime[j];
            } else {
                time += neededTime[j];
            }
            j++;
        }

        return new int[]{j, time};
    }
}