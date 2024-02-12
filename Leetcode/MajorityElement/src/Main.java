public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,11,2,2,2,1,1};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for(int i : nums){
            if(count == 0){
                candidate = i;
            }

            if(candidate == i) count++;
            else count--;
        }

        return candidate;
    }
}