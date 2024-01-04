public class Main {
    public static void main(String[] args) {
        char chars[] = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        if(chars.length == 0) return 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; ){
            int cnt = 0;
            int j = i;
            sb.append(chars[i]);
            while(j < chars.length && chars[i] == chars[j]){
                j++;
                cnt++;
            }
            if(cnt > 1){
                sb.append(Integer.toString(cnt));
            }
            i = j;
        }

        for(int i = 0; i < sb.length(); i++){
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}