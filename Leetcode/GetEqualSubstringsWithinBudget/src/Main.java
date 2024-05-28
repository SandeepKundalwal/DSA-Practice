public class Main {
    public static void main(String[] args) {
        String s = "krpgjbjjznpzdfy";
        String t = "nxargkbydxmsgby";
        int maxCost = 14;
        System.out.println(equalSubstring(s, t, maxCost));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();

        int maxi = 0;
        int left = 0, right = 0;
        while(right < n){
            maxCost -= Math.abs(s.charAt(right) - t.charAt(right));

            if(maxCost < 0){
                while(left <= right &&  maxCost < 0){
                    maxCost += Math.abs(s.charAt(left) - t.charAt(left));
                    left++;
                }
            }

            maxi = Math.max(maxi, right - left + 1);
            right++;
        }

        return maxi;
    }
}