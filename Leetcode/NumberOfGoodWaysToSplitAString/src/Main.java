public class Main {
    public static void main(String[] args) {
        String s = "aacaba";
        System.out.println(numSplits(s));
    }

    public static int numSplits(String s) {
        int currTracker[] = new int[26];
        int overallTracker[] = new int[26];

        int overallCount = 0, currCount = 0;
        for(char c : s.toCharArray()){
            if(overallTracker[c - 'a'] == 0){
                overallCount++;
            }
            overallTracker[c - 'a']++;
        }

        int goodSplits = 0;
        for(char c : s.toCharArray()){
            if(overallTracker[c - 'a'] - 1 == 0){
                overallCount--;
            }

            if(currTracker[c - 'a'] == 0){
                currCount++;
            }

            currTracker[c - 'a']++;
            overallTracker[c - 'a']--;

            if(overallCount == currCount){
                goodSplits++;
            }
        }
        return goodSplits;
    }
}