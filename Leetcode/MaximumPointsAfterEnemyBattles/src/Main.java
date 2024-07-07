public class Main {
    public static void main(String[] args) {
        int currentEnergy = 2;
        int enemyEnergies[] = {3,2,2};
        System.out.println(maximumPoints(enemyEnergies, currentEnergy));
    }

    public static long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        int n = enemyEnergies.length;

        long overallEnergy = 0;
        int minEnergy = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            overallEnergy += enemyEnergies[i];
            minEnergy = Math.min(minEnergy, enemyEnergies[i]);
        }

        if(minEnergy > currentEnergy){
            return 0;
        }

        return (long)(Math.ceil((overallEnergy - minEnergy + currentEnergy) / minEnergy));
    }
}