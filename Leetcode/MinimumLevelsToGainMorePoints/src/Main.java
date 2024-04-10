public class Main {
    public static void main(String[] args) {
        int possible[] = {1,0,1,0};
        System.out.println(minimumLevels(possible));
    }

    public static int minimumLevels(int[] possible) {
        int n = possible.length;

        int prefix[] = new int[n + 1];

        for(int i = 1; i < n + 1; i++){
            prefix[i] = prefix[i - 1] + (possible[i - 1] == 0 ? -1 : 1);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            int daniel = prefix[i];
            int bob = prefix[n] - daniel;

            if(daniel > bob){
                ans = Math.min(ans, i);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}