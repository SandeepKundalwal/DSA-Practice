public class Main {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int freq[] = new int[26];

        int idx = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(freq[c - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}