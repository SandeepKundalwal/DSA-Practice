public class Main {
    public static void main(String[] args) {
        int k = 11;
        System.out.println(minOperations(k));
    }

    // O(k)
    public static int minOperations(int k) {
        int operation = 0;
        int miniOperations = Integer.MAX_VALUE;
        for(int i = 1; i < k; i++){
            int duplicate = (k % i == 0 ? (k / i) - 1 : (k / i));
            miniOperations = Math.min(miniOperations, duplicate + operation);
            operation++;
        }
        return miniOperations == Integer.MAX_VALUE ? 0 : miniOperations;
    }

    // O(sqrt(k))
    public static int minOperationsOptimized(int k) {
        int a = (int)Math.ceil(Math.sqrt(k)) - 1;
        int b = (int)Math.ceil((k * 1.0) / (a + 1)) - 1;

        return a + b;
    }
}