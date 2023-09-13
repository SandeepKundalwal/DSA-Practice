import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int ratings[] = {1, 2, 2};
        System.out.println("Number of Candies Required: " + candy(ratings));
    }

    static class Rating {
        int index;
        int rating;

        public Rating(int index, int rating){
            this.index = index;
            this.rating = rating;
        }
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 1){
            return 1;
        }

        Rating ratingInOrder[] = new Rating[n];
        for(int i = 0; i < n; i++){
            ratingInOrder[i] = new Rating(i, ratings[i]);
        }

        Arrays.sort(ratingInOrder, (a, b) -> a.rating - b.rating);

        int candies[] = new int[n];
        for(int i = 0; i < n; i++){
            int index = ratingInOrder[i].index;
            int rating = ratingInOrder[i].rating;

            if(index == 0){
                candies[index] = (rating <= ratings[index + 1] ? 1 : candies[index + 1] + 1);
            } else if(index == n - 1){
                candies[index] = (rating <= ratings[index - 1] ? 1 : candies[index - 1] + 1);
            } else {
                if(rating <= ratings[index - 1] && rating <= ratings[index + 1]){
                    candies[index] = 1;
                } else {
                    if(rating == ratings[index - 1]){
                        candies[index] = 1 + candies[index + 1];
                    } else if (rating == ratings[index + 1]) {
                        candies[index] = 1 + candies[index - 1];
                    } else {
                        candies[index] = 1 + Math.max(candies[index - 1], candies[index + 1]);
                    }
                }
            }
        }

        int totalCandies = 0;
        for(int i = 0; i < n; i++){
            totalCandies += candies[i];
        }

        return totalCandies;
    }
}