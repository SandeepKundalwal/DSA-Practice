public class Main {
    public static void main(String[] args) {
        int citations[] = {0,1,3,5,6};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int ans = 0;
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = left + ((right - left) / 2);

            // System.out.println(left + " " + right + " " + mid);

            if(citations[mid] <= (n - mid)){
                ans = Math.max(ans, citations[mid]);
                left = mid + 1;
            } else {
                ans = Math.max(ans, n - mid);
                right = mid - 1;
            }
        }

        return ans;
    }
}