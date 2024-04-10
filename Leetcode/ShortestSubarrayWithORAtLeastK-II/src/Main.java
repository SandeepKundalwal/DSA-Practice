public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        int k = 2;
        System.out.println(minimumSubarrayLength(nums, k));
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        int bits[] = new int[32];

        int left = 0, right = 0;
        int mini = Integer.MAX_VALUE;
        while(right < n){
            for(int l = 0; l < 31; l++){
                if((nums[right] & (1 << l)) != 0){
                    bits[l] += 1;
                }
            }

            if(getNumber(bits) >= k){
                while(left <= right && getNumber(bits) >= k){
                    for(int l = 0; l < 31; l++){
                        if((nums[left] & (1 << l)) != 0){
                            bits[l] -= 1;
                        }
                    }
                    left++;
                }
                mini = Math.min(mini, right - left + 1);
            }
            right++;
        }
        return mini == Integer.MAX_VALUE ? -1 : mini + 1;
    }

    public static int getNumber(int bits[]){
        int num = 0;
        for(int k = 0; k < 31; k++){
            if(bits[k] > 0){
                num |= (1 << k);
            }
        }

        return num;
    }
}