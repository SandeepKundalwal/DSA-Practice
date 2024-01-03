public class Main {
    public static void main(String[] args) {
//        String bank[] = {"000","111","000"};
        String bank[] = {"011001","000000","010100","001000"};
        System.out.println(numberOfBeams(bank));
    }

    public static int numberOfBeams(String[] bank) {
        int prevBeams = 0;
        int laserBeams = 0;
        for(int i = 0; i < bank.length; i++){
            int currBeams = countLasers(bank[i]);
            if(currBeams == 0) continue;
            laserBeams += (currBeams * prevBeams);
            prevBeams = currBeams;
        }
        return laserBeams;
    }

    public static int countLasers(String lasers){
        int countLasers = 0;
        for(char laser : lasers.toCharArray()){
            countLasers += (laser - '0');
        }
        return countLasers;
    }
}