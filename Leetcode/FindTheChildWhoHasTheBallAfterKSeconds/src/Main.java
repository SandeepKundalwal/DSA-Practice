public class Main {
    public static void main(String[] args) {
        System.out.println(numberOfChild(3, 5));
    }

    public static int numberOfChild(int n, int k) {
        if(k < n){
            return k;
        }

        int mod = (k % (n - 1));
        int div = (k / (n - 1));

        // System.out.println(mod + " " + div);

        return (div % 2 == 0 ? 1 + mod : n - mod) - 1;
    }
}