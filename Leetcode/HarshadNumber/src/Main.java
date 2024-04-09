public class Main {
    public static void main(String[] args) {
        int x = 99;
        System.out.println(sumOfTheDigitsOfHarshadNumber(x));
    }

    public static int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;

        int originalX = x;
        while(originalX > 0){
            sum += (originalX % 10);
            originalX = (originalX / 10);
        }

        return x % sum == 0 ? sum : -1;
    }
}