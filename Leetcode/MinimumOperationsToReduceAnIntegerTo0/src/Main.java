public class Main {
    public static void main(String[] args) {
        System.out.println(minOperations(39));
    }

    public static int minOperations(int n) {
        return f(n);
    }

    public static int f(int n){
        if((n & (n - 1)) == 0){
            return 1;
        }

        int setBitIdx = -1;
        for(int i = 0; i < 31; i++){
            if((n & (1 << i)) != 0){
                setBitIdx = i;
                break;
            }
        }

        return 1 + Math.min(f(n + (1 << setBitIdx)), f(n - (1 << setBitIdx)));
    }
}