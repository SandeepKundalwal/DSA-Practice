public class Main {
    public static void main(String[] args) {
        int rating[] = {2,5,3,4,1};
        System.out.println(numTeams(rating));
    }

    public static int numTeams(int[] rating) {
        return countIncreasingTriplets(rating) + countDecreasingTriplets(rating);
    }

    public static int countIncreasingTriplets(int rating[]){
        int n = rating.length;

        int increasingTriplets = 0;
        for(int pivot = 1; pivot < n - 1; pivot++){
            int smallerThanPivot = 0, largerThanPivot = 0;

            for(int i = 0; i < pivot; i++){
                if(rating[i] < rating[pivot]){
                    smallerThanPivot++;
                }
            }

            for(int i = pivot + 1; i < n; i++){
                if(rating[i] > rating[pivot]){
                    largerThanPivot++;
                }
            }

            increasingTriplets += (smallerThanPivot * largerThanPivot);
        }

        return increasingTriplets;
    }

    public static int countDecreasingTriplets(int rating[]){
        int n = rating.length;

        int decreasingTriplets = 0;
        for(int pivot = 1; pivot < n - 1; pivot++){
            int smallerThanPivot = 0, largerThanPivot = 0;

            for(int i = 0; i < pivot; i++){
                if(rating[i] > rating[pivot]){
                    largerThanPivot++;
                }
            }

            for(int i = pivot + 1; i < n; i++){
                if(rating[i] < rating[pivot]){
                    smallerThanPivot++;
                }
            }

            decreasingTriplets += (smallerThanPivot * largerThanPivot);
        }

        return decreasingTriplets;
    }
}