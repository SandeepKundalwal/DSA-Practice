public class Main {
    public static void main(String[] args) {
        int n = 13;
        int k = 4;
        System.out.println(minChanges(n, k));
    }

    public static int minChanges(int n, int k) {
        int changes = 0;
        for(int bit = 0; bit < 32; bit++){
            int bitN = (n & (1 << bit));
            int bitK = (k & (1 << bit));
            if(bitN != bitK){
                if(bitK != 0){
                    return -1;
                } else {
                    changes++;
                }
            }
        }

        return changes;
    }
}