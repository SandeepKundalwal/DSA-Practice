public class Main {
    public static void main(String[] args) {
        int chalk[] = {5,1,5};
        int k = 22;
        System.out.println(chalkReplacer(chalk, k));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        long totalChalksPerCycle = 0;
        for(int c = 0; c < chalk.length; c++){
            totalChalksPerCycle += chalk[c];
        }

        int remainingChalks = (int)(k % totalChalksPerCycle);

        for(int i = 0; i < chalk.length; i++){
            if(chalk[i] > remainingChalks){
                return i;
            }

            remainingChalks -= chalk[i];
        }

        return 0;
    }
}