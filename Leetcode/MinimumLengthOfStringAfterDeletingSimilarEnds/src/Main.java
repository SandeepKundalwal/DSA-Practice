public class Main {
    public static void main(String[] args) {
        String s = "cabaabac";
        System.out.println(minimumLength(s));
    }

    public static int minimumLength(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right){
            char c = s.charAt(left);

            if(s.charAt(right) != c) break;

            while(left <= right && s.charAt(left) == c) left++;
            while(left <= right && s.charAt(right) == c) right--;
        }

        return left > right ? 0 : right - left + 1;
    }
}