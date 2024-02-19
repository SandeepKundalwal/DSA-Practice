public class Main {
    public static void main(String[] args) {
        System.out.println(lastFairyStanding(4, 3) + 1);
    }

    public static int lastFairyStanding(int n, int k) {
        // code here
        if(n == 1){
            return 0;
        }

        return (lastFairyStanding(n - 1, k) + k) % n;
    }
}