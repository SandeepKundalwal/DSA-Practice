public class Main {
    public static void main(String[] args) {
        int target[] = {1, 2, 2, 3, 3, 3};
        int arr[] = {3, 2, 2, 1, 3, 3};
        System.out.println(canBeEqual(target, arr));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length;
        int freq[] = new int[1001];
        for(int i = 0; i < n; i++){
            freq[arr[i]]++;
            freq[target[i]]--;
        }

        for(int i = 0; i < 1001; i++){
            if(freq[i] != 0){
                return false;
            }
        }

        return true;
    }
}