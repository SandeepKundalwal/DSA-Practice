public class Main {
    public static void main(String[] args) {
        int n = 4;
        char a[][] = {
                {'X','X','X','O'},
                {'X','O','X','X'},
                {'X','X','X','O'},
                {'X','O','X','X'}
        };
        System.out.println(largestSubsquare(n, a));
    }

    static int largestSubsquare(int n, char a[][]) {
        // code here
        Pair mat[][] = new Pair[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = new Pair();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] == 'X'){
                    if(i == 0 && j == 0){
                        mat[i][j].ver = 1;
                        mat[i][j].hori = 1;
                    } else if(i == 0){
                        mat[i][j].hori = mat[i][j - 1].hori + 1;
                        mat[i][j].ver = 1;
                    } else if(j == 0){
                        mat[i][j].ver = mat[i - 1][j].ver + 1;
                        mat[i][j].hori = 1;
                    } else {
                        mat[i][j].ver = mat[i - 1][j].ver + 1;
                        mat[i][j].hori = mat[i][j - 1].hori + 1;
                    }
                }
            }
        }

        int maxi = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(mat[i][j].ver == 0) continue;

                int mini = Math.min(mat[i][j].ver, mat[i][j].hori);

                // int k = 0;
                for( int k = mini; k >= 1; k--){
                    if(mat[i][j - k + 1].ver >= k && mat[i - k + 1][j].hori >= k){
                        maxi = Math.max(maxi, k);
                        break;
                    }
                }
            }
        }

        return maxi;
    }

    static class Pair{
        int ver;
        int hori;

        public Pair(){
            this.ver = 0;
            this.hori = 0;
        }

        public Pair(int ver, int hori){
            this.ver = ver;
            this.hori = hori;
        }
    }
}