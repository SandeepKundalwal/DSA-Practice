public class Main {
    public static void main(String[] args) {
        int n = 7;
        int k = 2;
        int a[] = {1, 7, 4, 3, 4, 8, 7};
        System.out.println(firstElementKTime(n, k, a));
    }

    public static int firstElementKTime(int n, int k, int[] a) {
        int freq[] = new int[201];
        for(int i = 0; i < n; i++){
            freq[a[i]]++;
            if(freq[a[i]] >= k){
                return a[i];
            }
        }
        return -1;
    }
}