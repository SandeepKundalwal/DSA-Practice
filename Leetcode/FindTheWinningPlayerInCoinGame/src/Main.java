public class Main {
    public static void main(String[] args) {
        int x = 2;
        int y = 7;
        System.out.println(losingPlayer(x, y));
    }

    public static String losingPlayer(int x, int y) {
        int turnX = x;
        int turnY = y / 4;

        // System.out.println(turnX + " " + turnY);

        return turnX > turnY ? (turnY % 2 == 1 ? "Alice" : "Bob") : (turnX % 2 == 1 ? "Alice" : "Bob");
    }
}