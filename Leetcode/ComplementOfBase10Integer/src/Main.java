public class Main {
    public static void main(String[] args) {
        System.out.println(bitwiseComplement(10));
    }

    public static int bitwiseComplement(int n) {
        if(n == 0){
            return 1;
        }

        int x = n;
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        return n ^ x;
    }
}