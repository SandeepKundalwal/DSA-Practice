public class Main {
    public static void main(String[] args) {
        System.out.println(canWinNim(6));
    }

    public static boolean canWinNim(int n) {
        return n % 4 == 0 ? false : true;
    }
}