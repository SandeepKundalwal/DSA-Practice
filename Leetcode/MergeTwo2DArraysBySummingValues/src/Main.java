import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums1[][] = {{1,2},{2,3},{4,5}};
        int nums2[][] = {{1,4},{3,2},{4,1}};
        System.out.println(Arrays.deepToString(mergeArrays(nums1, nums2)));
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int unique = 0;
        int ids[] = new int[1001];

        for(int pair[] : nums1) {
            if(ids[pair[0]] == 0) {
                unique++;
            }
            ids[pair[0]] += pair[1];
        }

        for(int pair[] : nums2) {
            if(ids[pair[0]] == 0) {
                unique++;
            }
            ids[pair[0]] += pair[1];
        }

        int i = 0;
        int res[][] = new int[unique][2];
        for(int j = 0; j < 1001; j++) {
            if(ids[j] != 0) {
                res[i][0] = j;
                res[i][1] = ids[j];
                i++;
            }
        }

        return res;
    }
}