public class Main {
    public static void main(String[] args) {
        System.out.println(DivisibleByEight("16"));
    }

    static int DivisibleByEight(String s){
        //code here
        int n = s.length();
        if(n < 4){
            return Integer.parseInt(s) % 8 == 0 ? 1 : -1;
        }

        int lastThree = Integer.parseInt(s.substring(n - 3));
        return lastThree % 8 == 0 ? 1 : -1;
    }
}