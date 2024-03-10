import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String arr[] = {"cab","ad","bad","c"};
        System.out.println(Arrays.toString(shortestSubstrings(arr)));
    }

    public static String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String ans[] = new String[n];

        for(int i = 0; i < n; i++){
            String s = arr[i];
            for(int j = 0; j < s.length(); j++){
                StringBuilder sb = new StringBuilder();
                for(int k = j; k < s.length(); k++){
                    sb.append(s.charAt(k));
                    boolean contains = false;
                    for(int l = 0; l < n; l++){
                        if(i != l && arr[l].contains(sb.toString())){
                            contains = true;
                            break;
                        }
                    }

                    if(!contains){
                        if(ans[i] != null){
                            if(ans[i].length() == sb.length()){
                                if(ans[i].compareTo(sb.toString()) > 0){
                                    ans[i] = sb.toString();
                                }
                            } else if(ans[i].length() > sb.length()){
                                ans[i] = sb.toString();
                            }
                        } else {
                            ans[i] = sb.toString();
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(ans[i] == null){
                ans[i] = "";
            }
        }
        return ans;
    }
}