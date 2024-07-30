public class Main {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(checkString(s));
    }

    public static boolean checkString(String s) {
        boolean foundB = false;
        for(char c : s.toCharArray()){
            if(c == 'b'){
                foundB = true;
            } else {
                if(foundB) return false;
            }
        }

        return true;
    }
}