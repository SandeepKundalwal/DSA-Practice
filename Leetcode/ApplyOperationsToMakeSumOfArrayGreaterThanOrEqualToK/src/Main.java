public class Main {
    public static void main(String[] args) {
        int k = 11;
        System.out.println(minOperations(k));
    }

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
}