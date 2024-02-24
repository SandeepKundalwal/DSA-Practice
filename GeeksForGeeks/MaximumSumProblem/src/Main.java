public class Main {
    public static void main(String[] args) {
        System.out.println(maxSum(24));
    }

    public static int maxSum(int n)
    {
        if(n == 0) return 0;
        //code here
        int maxi[] = {0};
        f(n, maxi);
        return Math.max(n, maxi[0]);
    }

    public static int f(int n, int maxi[]){
        if(n <= 0){
            return 0;
        }

        int first = Math.max(n/2, f(n/2, maxi));
        int second = Math.max(n/3, f(n/3, maxi));
        int third = Math.max(n/4, f(n/4, maxi));

        int sum = first + second + third;

        maxi[0] = Math.max(maxi[0], sum);

        return sum;
    }
}