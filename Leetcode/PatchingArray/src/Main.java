public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,31,33};
        int n = 2147483647;
        System.out.println(minPatches(nums, n));
    }

    public static int minPatches(int[] nums, int n) {
        long maxNo = 0;
        int patches = 0;

        int idx = 0;
        while(maxNo < n){
            if(idx < nums.length && maxNo + 1 >= nums[idx]){
                maxNo += nums[idx++];
            } else {
                patches++;
                maxNo += (maxNo + 1);
            }
        }

        return patches;
    }
}