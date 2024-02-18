public class Main {
    public static void main(String[] args) {
        String words[] = {"a","aba","ababa","aa"};
        System.out.println(countPrefixSuffixPairs(words));
    }

    public static int countPrefixSuffixPairs(String[] words) {
        int n = words.length;

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(words[i].length() > words[j].length()) continue;

                if(isPrefixSuffix(words[i], words[j])){
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPrefixSuffix(String w1, String w2){
        int i = 0;
        int j = 0;
        while(i < w1.length()){
            if(w1.charAt(i) != w2.charAt(j)){
                return false;
            }
            i++;
            j++;
        }

        i = w1.length() - 1;
        j = w2.length() - 1;
        while(i >= 0){
            if(w1.charAt(i) != w2.charAt(j)){
                return false;
            }
            i--;
            j--;
        }

        return true;
    }
}