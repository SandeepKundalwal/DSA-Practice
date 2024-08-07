public class Main {
    public static void main(String[] args) {
        int l = 1;
        int r = 4536;
        System.out.println(nonSpecialCount(l, r));
    }

    public static int nonSpecialCount(int l, int r) {
        int sqrtL = (int)Math.sqrt(l);
        int sqrtR = (int)Math.sqrt(r);
        int primes[] = new int[sqrtR + 1];

        for(int p = 2; p * p <= sqrtR; p++){
            if(primes[p] == 0){
                for(int i = p * p; i <= sqrtR; i += p){
                    primes[i] = 1;
                }

            }
        }

        int special = 0;
        for(int i = sqrtL; i <= sqrtR; i++){
            int iSquared = i * i;
            if(primes[i] == 0 && iSquared >= l && iSquared <= r){
                special++;
            }
        }

        return ((r - l + 1) - special) + (l == 1 ? 1 : 0);
    }
}