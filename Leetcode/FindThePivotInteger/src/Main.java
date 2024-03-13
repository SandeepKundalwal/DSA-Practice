public class Main {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(pivotInteger(n));
    }

    public static int pivotInteger(int n) {
        int left = 1, right = n;

        while(left <= right){
            int mid = left + ((right - left) / 2);

            int sums[] = possible(mid, n);

            if(sums[0] == sums[1]){
                return mid;
            } else if(sums[0] < sums[1]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static int[] possible(int mid, int n){
        int leftSum = 0;
        for(int i = 1; i <= mid; i++){
            leftSum += i;
        }

        int rightSum = 0;
        for(int i = mid; i <= n; i++){
            rightSum += i;
        }

        return new int[]{leftSum, rightSum};
    }
}