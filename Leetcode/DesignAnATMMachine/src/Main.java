import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String queryType[] = {"ATM", "deposit", "withdraw", "deposit", "withdraw", "withdraw"};
        int queries[][] = {{}, {0,0,1,2,1}, {600},{0,1,0,1,1}, {600}, {550}};

        ATM atm = new ATM();
        for(int i = 0; i < queryType.length; i++){
            String query = queryType[i];
            if(query.equals("ATM")){
                System.out.println("null");
            } else if(query.equals("deposit")){
                atm.deposit(queries[i]);
                System.out.println("null");
            } else {
                System.out.println(Arrays.toString(atm.withdraw(queries[i][0])));
            }
        }
    }
}