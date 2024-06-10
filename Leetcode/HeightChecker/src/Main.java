public class Main {
    public static void main(String[] args) {
        int heights[] = {1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }

    public static int heightChecker(int[] heights) {
        int heightsFrequency[] = new int[101];
        for(int height : heights){
            heightsFrequency[height]++;
        }

        int count = 0;
        int expectedIdx = 100;
        int actualIdx = heights.length - 1;
        while(expectedIdx >= 0){
            if(heightsFrequency[expectedIdx] != 0){
                if(heights[actualIdx] != expectedIdx){
                    count++;
                }
                actualIdx--;
                heightsFrequency[expectedIdx]--;
            } else {
                expectedIdx--;
            }
        }

        return count;
    }
}