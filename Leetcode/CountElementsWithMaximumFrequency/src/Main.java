public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,2,3,1,4,3,3,1,2};
        System.out.println(maxFrequencyElements(nums));
    }

    public static int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101];
        for(int i = 0; i < nums.length; i++){
            freq[nums[i]]++;
        }

        int maxFrequency = 0;
        for(int i = 0; i < 101; i++){
            maxFrequency = Math.max(maxFrequency, freq[i]);
        }

        int count = 0;
        for(int i = 0; i < 101; i++){
            if(maxFrequency == freq[i]){
                count++;
            }
        }

        return count * maxFrequency;
    }
}