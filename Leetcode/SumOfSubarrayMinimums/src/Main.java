import java.util.Stack;

public class Main {
    static int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        int arr[] = {3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int leftArr[] = new int[n];
        int rightArr[] = new int[n];

        Stack<Pair> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int cnt = 1;
            while(!stack.isEmpty() && stack.peek().first > arr[i]){
                cnt += stack.pop().second;
            }
            leftArr[i] = cnt;
            stack.push(new Pair(arr[i], cnt));
        }

        stack.clear();

        for(int i = n - 1; i >= 0; i--){
            int cnt = 1;
            while(!stack.isEmpty() && stack.peek().first >= arr[i]){
                cnt += stack.pop().second;
            }
            rightArr[i] = cnt;
            stack.push(new Pair(arr[i], cnt));
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = (int)(ans + (long)(arr[i] * (long)(leftArr[i] * rightArr[i]) % MOD) % MOD) % MOD;
        }
        return ans;
    }

    static class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}