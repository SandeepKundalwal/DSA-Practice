import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String pattern = "geeks";
        String text = "geeksforgeeks";
        System.out.println(search(pattern, text));
    }

    static ArrayList<Integer> search(String pattern, String text) {
        char input[] = new char[text.length() + pattern.length() + 1];
        int idx = 0;
        for(char c : pattern.toCharArray()){
            input[idx++] = c;
        }
        input[idx++] = '$';
        for(char c : text.toCharArray()){
            input[idx++] = c;
        }

        int zValues[] = createZ(input);

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < input.length; i++){
            if(zValues[i] == pattern.length()){
                ans.add(i - pattern.length());
            }
        }
        return ans;
    }

    static int[] createZ(char input[]){
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