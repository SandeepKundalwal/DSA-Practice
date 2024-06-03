public class Main {
    public static void main(String[] args) {
        String s = "coaching";
        String t = "coding";
        System.out.println(appendCharacters(s, t));
    }

    public static int appendCharacters(String s, String t) {
        int idxT = 0;

        for(int idxS = 0; idxS < s.length() && idxT < t.length(); idxS++){
            if(s.charAt(idxS) == t.charAt(idxT)) idxT++;
        }

        return t.length() - idxT;
    }
}