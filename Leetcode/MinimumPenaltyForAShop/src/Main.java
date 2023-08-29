public class Main {
    public static void main(String[] args) {
        System.out.println("CLosing Hour: " + bestClosingTime("YYNY"));
    }

    /*
     Penalties:
        1. Shop open & no customer -> penalty + 1;
        2. Shop closed & customer came -> penalty + 1;
    */
    public static int bestClosingTime(String customers) {
        int n = customers.length();
        char c[] = customers.toCharArray();
        Customer p[] = new Customer[n];

        for(int i = 0; i < n; i++){
            if(c[i] == 'Y'){
                p[i] = (i == 0) ? new Customer(0, 1) : new Customer(p[i - 1].absent, 1 + p[i - 1].present);
            } else {
                p[i] = (i == 0) ? new Customer(1, 0) : new Customer(1 + p[i - 1].absent, p[i - 1].present);
            }
        }

        int closingHour = -1;
        int penalty = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int currPenalty = Integer.MAX_VALUE;
            if(c[i] == 'Y'){
                currPenalty = (i == 0) ? p[n - 1].present : p[i].absent + (p[n - 1].present - p[i - 1].present);
            } else {
                currPenalty = (i == 0) ? p[n - 1].present : p[i - 1].absent + (p[n - 1].present - p[i].present);
            }

            if(currPenalty < penalty){
                penalty = currPenalty;
                closingHour = i;
            }
        }
        // handling case when we should close the shop on last day
        return p[n - 1].absent < penalty ? n : closingHour;
    }

    public static class Customer{
        int absent;
        int present;

        public Customer(int absent, int present){
            this.absent = absent;
            this.present = present;
        }
    }
}