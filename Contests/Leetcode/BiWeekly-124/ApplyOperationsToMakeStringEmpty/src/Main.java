public class Main {
    public static void main(String[] args) {
        String s = "aabcbbca";
        System.out.println(lastNonEmptyString(s));
    }

    public static String lastNonEmptyString(String s) {
        int freq[] = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        int maxi = 0;
        for(int i : freq){
            maxi = Math.max(maxi, i);
        }

        StringBuilder ans = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(freq[c - 'a'] == maxi){
                ans.append(c);
                freq[c - 'a'] = 0;
            }
        }
        ans.reverse();
        return ans.toString();
    }
}