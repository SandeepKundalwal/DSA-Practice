public class Main {
    public static void main(String[] args) {
        int n = 3;
        int M[][] = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };
        System.out.println("Found Celebrity At Index: " + celebrity(M, n));
    }

    //Function to find if there is a celebrity in the party or not.
    public static int celebrity(int M[][], int n){
        // code here
        boolean knowsSomeone[] = new boolean[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(M[i][j] == 1){
                    knowsSomeone[i] = true;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(!knowsSomeone[i]){
                int cnt = 0;
                for(int j = 0; j < n; j++){
                    if(M[j][i] == 1){
                        cnt++;
                    }
                }

                if(cnt == n - 1){
                    return i;
                }
            }
        }
        return -1;
    }
}