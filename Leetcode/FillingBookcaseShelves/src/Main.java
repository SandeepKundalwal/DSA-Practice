import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int books[][] = {{7,3},{8,7},{2,7},{2,5}};
        int shelfWidth = 10;
        System.out.println(minHeightShelves(books, shelfWidth));
    }

    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int MEMO[] = new int[books.length];
        Arrays.fill(MEMO, -1);
        return f(0, books, shelfWidth, MEMO);
    }

    public static int f(int idx, int books[][], int shelfWidth, int MEMO[]){
        if(idx >= books.length){
            return 0;
        }

        if(MEMO[idx] != -1){
            return MEMO[idx];
        }

        int maxHeight = 0;
        int currWidth = shelfWidth;
        int res = Integer.MAX_VALUE;
        for(int i = idx; i < books.length; i++){
            int width = books[i][0];
            int height = books[i][1];

            if(width > currWidth){
                break;
            }

            currWidth -= width;
            maxHeight = Math.max(maxHeight, height);

            res = Math.min(res, maxHeight + f(i + 1, books, shelfWidth, MEMO));
        }

        return MEMO[idx] = res;
    }
}