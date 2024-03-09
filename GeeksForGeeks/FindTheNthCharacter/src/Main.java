public class Main {
    public static void main(String[] args) {
        String s = "1100";
        int r = 2;
        int n = 3;
        System.out.println(nthCharacter(s, r, n));
    }

    public static char nthCharacter(String s, int r, int n)
    {
        int len = s.length();
        for(int i = 0; i < r; i++){
            StringBuilder newSB = new StringBuilder();
            for(int j = 0; j < len && newSB.length() < len; j++){
                if(s.charAt(j) == '0'){
                    newSB.append("01");
                } else {
                    newSB.append("10");
                }
            }
            s = newSB.toString();
        }
        return s.charAt(n);
    }
}