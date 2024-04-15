public class Main {
    public static void main(String[] args) {
        String s = "leafbcaef";
        System.out.println(isSubstringPresent(s));
    }

    public static boolean isSubstringPresent(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i = n - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }

        for(int i = 1; i < n; i++){
            if(s.charAt(i - 1) == s.charAt(i)){
                if(sb.indexOf(s.substring(i - 1, i + 1)) != -1){
                    return true;
                }
            }
        }

        return false;
    }
}