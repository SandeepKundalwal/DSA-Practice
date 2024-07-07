public class Main {
    public static void main(String[] args) {
        System.out.println(getEncryptedString("dart", 3));
    }

    public static String getEncryptedString(String s, int k) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(s.charAt((i + k) % n));
        }

        return sb.toString();
    }
}