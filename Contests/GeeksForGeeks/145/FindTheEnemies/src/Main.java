import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int k = 3;
        int col[] = {0,0,1};
        int count[] = {1,1,1};
        System.out.println(findEnemies(n, m, k, col, count));
    }

    public static ArrayList<ArrayList<Integer>> findEnemies(int n, int m, int k, int[] col, int[] count) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ans.add(new ArrayList<>());
            for(int j = 0; j < m; j++){
                ans.get(i).add(-1);
            }
        }

        int idx = 0;
        for(int i = 0; i < n; i++){
            int enemies = count[i];
            if(enemies > 0){
                for(int j = 0; j < enemies; j++){
                    // System.out.println(ans.get(i));
                    ans.get(i).set(col[idx], idx);
                    idx++;
                }
            }
        }
        return ans;
    }
}