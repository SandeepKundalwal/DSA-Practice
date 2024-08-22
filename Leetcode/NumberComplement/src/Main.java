public class Main {
    public static void main(String[] args) {
        System.out.println(findComplement(1000000000));
    }

    public static int findComplement(int num) {
        int x = num;
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        return num ^ x;
    }
}