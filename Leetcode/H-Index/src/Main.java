import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int citations[] = new int[n];
        for(int i = 0; i < n; i++){
            citations[i] = in.nextInt();
        }

        System.out.println("H-Index: " + hIndex(citations));
    }

//    3 0 6 1 5
    public static int hIndex(int citations[]){
        int left = 0;
        int right = citations.length;

        int ans = 0;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            int papersWithAboveThresholdCitations = checkHIndex(mid, citations);

            if(papersWithAboveThresholdCitations >= mid){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

        private static int checkHIndex(int threshold, int citations[]){
            int papersWithAboveThresholdCitations = 0;
            for(int i = 0; i < citations.length; i++){
                if(citations[i] >= threshold){
                    papersWithAboveThresholdCitations++;
                }
            }
            return papersWithAboveThresholdCitations;
        }
}