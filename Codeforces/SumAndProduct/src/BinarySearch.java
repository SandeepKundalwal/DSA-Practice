// TLE at 5th Test Case
public class BinarySearch {
    public static long findPairs(long x, long y, int n, int a[]){
        long cnt = 0;
        for(int i = 0; i < n - 1; i++){
            double sumTarget = x - a[i];
            double multiplicationTarget = (double) y / a[i];

            if(Double.compare(sumTarget, multiplicationTarget) == 0){
                long lowerBound = getLowerBound(i + 1, n, (int)sumTarget, a);
                long upperBound = getUpperBound(i + 1, n, (int)sumTarget, a);
                cnt = cnt + upperBound - lowerBound;
            }
        }
        return cnt;
    }

    public static int getLowerBound(int start, int end, int key, int a[]){
        //find lower bound;
        while(start < end){
            int mid = start + ((end - start) >> 1);

            if(a[mid] < key){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static int getUpperBound(int start, int end, int key, int a[]){
        while(start < end){
            int mid = start + ((end - start) >> 1);

            if(a[mid] <= key){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
