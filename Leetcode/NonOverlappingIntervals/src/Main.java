import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int intervals[][] = new int[][]{
                {1,2},{2,3},{3,4},{1,3}
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }

    /**
     Solution 1: Gives TLE even after converting into Bottom-Up Approach which was obvious given the contraints
     1. find the length of the longest non-overlapping interval
     2. subtract it from the length of the intervals array

     Solution 2:
     1. Convert the above thing in Binary Search somehow
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 1){
            return 0;
        }

        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int DP[] = new int[n + 1];

        for(int i = n - 1; i >= 0; i--){
            int nextIndex = binarySearch(i, intervals[i][1], intervals);
            DP[i] = Math.max(DP[i + 1], 1+ DP[nextIndex]);
        }
        return n - DP[0];
    }

    public static int binarySearch(int currIdx, int target, int intervals[][]){
        int left = currIdx, right = intervals.length;

        while(left < right){
            int mid = left + ((right - left) / 2);
            if(intervals[mid][0] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}