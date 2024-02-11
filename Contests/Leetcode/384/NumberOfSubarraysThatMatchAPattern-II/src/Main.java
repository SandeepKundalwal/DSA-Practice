public class Main {
    public static void main(String[] args) {
        System.out.println(countMatchingSubarrays(new int[]{1,4,4,1,3,5,5,3}, new int[]{1,0,-1}));
    }

    public static int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int p = pattern.length;

        StringBuilder nString = new StringBuilder();
        for(int i = 0; i < p; i++){
            if(pattern[i] == -1){
                nString.append('2');
            } else {
                nString.append(pattern[i]);
            }
        }
        nString.append('$');
        for(int i = 0; i < n - 1; i++){
            if(nums[i] < nums[i + 1]){
                nString.append('1');
            } else if(nums[i] == nums[i + 1]){
                nString.append('0');
            } else {
                nString.append('2');
            }
        }

        return Z_Algorithm(nString.substring(0, p), nString.toString());
    }

    public static int Z_Algorithm(String p, String s){
        int count = 0;
        //creating Z-Values Table
        int[] ZTable = createZTable(s);

        for(int i = 0; i < ZTable.length; i++){
            if(ZTable[i] == p.length()){
                count++;
            }
        }
        return count;
    }

    public static int[] createZTable(String inputString){
        int[] ZTable = new int[inputString.length()];
        int left = 0, right = 0;

        for(int k = 1; k < inputString.length(); k++){
            if(k > right){
                left = right = k;
                while(right < inputString.length() && inputString.charAt(right) == inputString.charAt(right - left)){
                    right++;
                }
                ZTable[k] = right - left;
                right--;
            } else {
                //working inside Z-Box
                int k1 = k - left;
                if(ZTable[k1] < right - k + 1){
                    ZTable[k] = ZTable[k1];
                } else {
                    left = k;
                    while(right < inputString.length() && inputString.charAt(right) == inputString.charAt(right - left)){
                        right++;
                    }
                    ZTable[k] = right - left;
                    right--;
                }
            }
        }
        return ZTable;
    }
}