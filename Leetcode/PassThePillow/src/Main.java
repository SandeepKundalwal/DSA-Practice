public class Main {
    public static void main(String[] args) {
        System.out.println(passThePillow(3, 1000));
    }

    public static int passThePillow(int n, int time) {
        if(time < n){
            return time + 1;
        }

        int mod = (time % (n - 1));
        int div = (time / (n - 1));

        return div % 2 == 0 ? 1 + mod : n - mod;
    }
}