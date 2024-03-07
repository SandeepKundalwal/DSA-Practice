public class Main {
    public static void main(String[] args) {
        String s = "heheheh";
        int n = s.length();
        System.out.println(longestSubstring(s, n));
    }

    static String longestSubstring(String s, int n) {
        // code here
        int maxi = 0;
        String S = new String();
        for(int i = 0; i < n; i++){
            int currMax = ZAlgo(s.substring(i));
            if(currMax > maxi){
                maxi = currMax;
                S = s.substring(i, i + maxi);
            }
        }
        return maxi == 0 ? "-1" : S;
    }

    public static int ZAlgo(String s){
        int zValues[] = ZValues(s.toCharArray());

        int maxi = 0;
        for(int i = 0; i < zValues.length; i++){
            // System.out.print(zValues[i] + " ");
            if(zValues[i] > maxi && (i) >= zValues[i]){
                maxi = zValues[i];
            }
        }
        // System.out.println();

        return maxi;
    }

    public static int[] ZValues(char input[]){
        int Z[] = new int[input.length];

        int left = 0, right = 0;
        for(int k = 1; k < input.length; k++){
            if(k > right){
                left = right = k;
                while(right < input.length && input[right - left] == input[right]){
                    right++;
                }
                Z[k] = right - left;
                right--;
            } else {
                int k1 = k - left;
                if(Z[k1] < right - k + 1){
                    Z[k] = Z[k1];
                } else {
                    left = k;
                    while(right < input.length && input[right - left] == input[right]){
                        right++;
                    }
                    Z[k] = right - left;
                    right--;
                }
            }
        }
        return Z;
    }
}