public class Main {
    public static void main(String[] args) {
        int bills[] = {5,5,5,5,20,20,5,5,5,5};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int totalFiveDollarBills = 0;
        int totalTenDollarBills = 0;
        for(int bill : bills){
            if(bill == 5){
                totalFiveDollarBills++;
            } else if(bill == 10) {
                if(totalFiveDollarBills >= 1){
                    totalFiveDollarBills--;
                    totalTenDollarBills++;
                } else {
                    return false;
                }
            } else {
                if(totalTenDollarBills >= 1 && totalFiveDollarBills >= 1){
                    totalTenDollarBills--;
                    totalFiveDollarBills--;
                } else if(totalFiveDollarBills >= 3){
                    totalFiveDollarBills -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}