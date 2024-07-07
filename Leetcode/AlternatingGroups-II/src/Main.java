import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int k = 3;
        int colors[] = {0,1,0,1,0};
        System.out.println(numberOfAlternatingGroups(colors, k));
    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;

        FenwickTree BIT = new FenwickTree(n);

        for(int i = 0; i < n; i++){
            int prev = (i - 1 + n) % n;
            int next = (i + 1) % n;
            if(colors[prev] == colors[i] || colors[i] == colors[next]){
                BIT.update(i + 1, 1);
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(i + k <= n){
                if(BIT.query(0, 0, i + 1, i + k - 1)){
                    count++;
                }
            } else {
                int remaining = (i + k) - (n);
                if(BIT.query(0, remaining - 1, i + 1, n)){
                    count++;
                }
            }
        }

        return count;
    }

    static class FenwickTree{
        int n;
        int bit[];

        public FenwickTree(int n){
            this.n = n + 1;
            this.bit = new int[this.n];
        }

        public void update(int idx, int val){
            while(idx < this.n){
                this.bit[idx] += val;
                idx += (idx & -idx);
            }
        }

        public int find(int idx){
            int ans = 0;
            while(idx > 0){
                ans += this.bit[idx];
                idx -= (idx & -idx);
            }
            return ans;
        }

        public boolean query(int a, int b, int c, int d){
            return find(b) + (find(d) - find(c)) <= 0;
        }

        public void print(){
            System.out.println(Arrays.toString(this.bit));
        }
    }
}