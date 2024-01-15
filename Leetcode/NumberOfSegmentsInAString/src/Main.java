public class Main {
    public static void main(String[] args) {
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }

    public static int countSegments(String s) {
        if(s.isEmpty()) return 0;

        int cnt = 0;
        for(int i = 0; i < s.length();){
            if(s.charAt(i) != ' '){
                int j = i + 1;
                while(j < s.length() && s.charAt(j) != ' '){
                    j++;
                }
                cnt++;
                i = j;
            }
            i++;
        }
        return cnt;
    }
}