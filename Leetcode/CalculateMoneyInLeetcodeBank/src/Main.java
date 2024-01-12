public class Main {
    public static void main(String[] args) {
        System.out.println(totalMoney(100));
    }

    public static int totalMoney(int n) {
        int monday = 1;
        int totalMoney = 0;

        int i = 0;
        while(i++ < n){
            totalMoney += monday;
            for(int j = 1; i < n && j <= 6; j++, i++){
                totalMoney += (monday + j);
            }
            monday++;
        }
        return totalMoney;
    }
}