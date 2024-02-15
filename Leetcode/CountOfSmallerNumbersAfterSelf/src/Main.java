import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int nums[] = {5,2,6,1};
        System.out.println(countSmaller(nums));
    }

    public static List<Integer> countSmaller(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        FenwickTree BIT = new FenwickTree(max - (--min));

        List<Integer> ans = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--){
            int e = nums[i] - min;
            ans.add(BIT.query(e - 1));
            BIT.update(e, 1);
        }

        Collections.reverse(ans);
        return ans;
    }

    static class FenwickTree{
        int n;
        int bitTree[];

        public FenwickTree(int n){
            this.n = n;
            this.bitTree = new int[n + 1];
        }

        public void update(int idx, int val){
            while(idx <= this.n){
                this.bitTree[idx] += val;
                idx += (idx & -idx);
            }
        }

        public int query(int idx){
            int ans = 0;
            while(idx > 0){
                ans += this.bitTree[idx];
                idx -= (idx & -idx);
            }
            return ans;
        }
    }
}