import java.util.*;

public class Main {
    public static void main(String[] args) {
        int nums[] = {2,1,3,3};
        System.out.println(Arrays.toString(resultArray(nums)));
    }

    public static int[] resultArray(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i], 0);
        }
        int m = 1;
        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            it.setValue(m++);
        }

        FenwickTree bitA = new FenwickTree(m + 1);
        FenwickTree bitB = new FenwickTree(m + 1);
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int no = map.get(nums[i]);


            int k = 0;
            if(i == 0) k = 0;
            else if(i == 1) k = 1;
            else {
                int countA = bitA.range_query(no);
                int countB = bitB.range_query(no);

                // System.out.println(nums[i] + " " + countA + " " + countB);

                if(countA >= countB){
                    if(countA == countB && A.size() > B.size()){
                        k = 1;
                    }
                } else {
                    k = 1;
                }
            }

            if(k == 0){
                A.add(nums[i]);
                bitA.update(no, 1);
                // System.out.println(Arrays.toString(bitA.bit));
            } else {
                B.add(nums[i]);
                bitB.update(no, 1);
                // System.out.println(Arrays.toString(bitB.bit));
            }
        }

        int idx = 0;
        for(int e : A){
            nums[idx++] = e;
        }

        for(int e : B){
            nums[idx++] = e;
        }

        return nums;
    }

    static class FenwickTree{
        int bit[];
        int n;

        public FenwickTree(int n){
            this.bit = new int[n];
            this.n = n;
        }

        public void update(int idx, int val){
            while(idx < this.n){
                this.bit[idx] += val;
                idx += (idx & -idx);
            }
        }

        public int query(int idx){
            int ans = 0;
            while(idx > 0){
                ans += this.bit[idx];
                idx -= (idx & -idx);
            }
            return ans;
        }

        public int range_query(int no){
            int for_n = query(n - 1);
            int for_no = query(no);
            // System.out.println(for_n + " " + for_no);
            return for_n - for_no;
        }
    }
}