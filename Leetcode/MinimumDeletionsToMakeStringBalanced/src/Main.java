public class Main {
    public static void main(String[] args) {
        String s = "ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa";
        System.out.println(minimumDeletions(s));
    }

    public static int minimumDeletions(String s) {
        int countA = 0, countB = 0;
        for(char c : s.toCharArray()){
            if(c == 'a'){
                countA++;
            } else {
                countB++;
            }
        }

        if(countA == 0 || countB == 0) return 0;

        int count = 0;
        int left = 0, right = s.length() - 1;
        while(left < right){
            while(left < right && s.charAt(left) == 'a'){
                left++;
                countA--;
            }

            while(right > left && s.charAt(right) == 'b'){
                right--;
                countB--;
            }

            if(countA < countB){
                while(right > left && s.charAt(right) == 'a'){
                    count++;
                    countA--;
                    right--;
                }
            } else {
                while(left < right && s.charAt(left) == 'b'){
                    count++;
                    countB--;
                    left++;
                }
            }
        }

        return count;
    }
}