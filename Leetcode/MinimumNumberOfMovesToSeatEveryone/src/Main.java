public class Main {
    public static void main(String[] args) {
        int seats[] = {3,1,5};
        int students[] = {2,7,4};
        System.out.println(minMovesToSeat(seats, students));
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;

        int seatsPositions[] = new int[101];
        int studentsPositions[] = new int[101];
        for(int i = 0; i < n; i++){
            seatsPositions[seats[i]]++;
            studentsPositions[students[i]]++;
        }

        int moves = 0;
        int seatsIdx = 100, studentsIdx = 100;
        while(seatsIdx > 0 || studentsIdx > 0){
            while(seatsIdx > 0 && seatsPositions[seatsIdx] == 0) seatsIdx--;
            while(studentsIdx > 0 && studentsPositions[studentsIdx] == 0) studentsIdx--;

            moves += Math.abs(studentsIdx - seatsIdx);
            seatsPositions[seatsIdx]--;
            studentsPositions[studentsIdx]--;
        }

        return moves;
    }
}