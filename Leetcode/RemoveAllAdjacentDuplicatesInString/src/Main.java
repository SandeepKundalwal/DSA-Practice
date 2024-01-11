public class Main {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        if(s.length() <= 1){
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int lastIdx = 0;
        sb.append(s.charAt(lastIdx));
        for(int i = 1; i < s.length(); i++){
            if(lastIdx >= 0 && sb.charAt(lastIdx) == s.charAt(i)){
                sb.deleteCharAt(lastIdx--);
            } else{
                lastIdx++;
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}