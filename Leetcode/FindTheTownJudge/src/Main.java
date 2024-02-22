public class Main {
    public static void main(String[] args) {
        int n = 3;
        int trust[][] = {{1,3},{2,3}};
        System.out.println(findJudge(n, trust));
    }

    public static int findJudge(int n, int[][] trust) {
        if(trust.length == 0) return (n == 1) ? 1 : -1;

        int trusted[] = new int[n + 1];
        int trusting[] = new int[n + 1];

        for(int t[] : trust){
            trusted[t[1]]++;
            trusting[t[0]]++;
        }

        for(int i = 1; i <= n; i++){
            if(trusted[i] == n - 1 && trusting[i] == 0){
                return i;
            }
        }

        return -1;
    }
}