public class Main {
    public static void main(String[] args) {
        String s = "ELELEEL";
        System.out.println(minimumChairs(s));
    }

    public static int minimumChairs(String s) {
        int chairsNeeded = 0;
        int maxChairsNeeded = 0;
        for(char c : s.toCharArray()){
            chairsNeeded = c == 'E' ? chairsNeeded + 1 : chairsNeeded - 1;
            maxChairsNeeded = Math.max(chairsNeeded, maxChairsNeeded);
        }
        return maxChairsNeeded;
    }
}