public class Main {
    public static void main(String[] args) {
        String s = "xaxcd";
        int k = 4;
        System.out.println(getSmallestString(s, k));
    }

    public static String getSmallestString(String s, int k) {
        if(k == 0) return s;

        int n = s.length();

        StringBuilder sb = new StringBuilder();

        int i = 0;
        for(; i < n; i++){
            if(k <= 0) break;

            char c = s.charAt(i);

            int disR = 26 - (c - 'a');
            int disL = (c - 'a');

            // System.out.println(disR + " " + disL);

            if(disR < disL){
                if(k >= disR){
                    sb.append('a');
                    k -= disR;
                } else {
                    sb.append((char)(c- k));
                    k = 0;
                }
            } else {
                if(k >= disL){
                    sb.append('a');
                    k -= disL;
                } else {
                    sb.append((char)(c - k));
                    k = 0;
                }
            }
        }

        while(i < n){
            sb.append(s.charAt(i++));
        }

        return sb.toString();
    }
}