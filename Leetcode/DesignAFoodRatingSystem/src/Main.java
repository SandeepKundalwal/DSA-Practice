import java.util.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int ratings[] = {9,12,8,15,14,7};
        String foods[] = {"kimchi","miso","sushi","moussaka","ramen","bulgogi"};
        String cuisines[] = {"korean","japanese","japanese","greek","japanese","korean"};

        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);

        System.out.println(foodRatings.highestRated("korean"));
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi", 16);
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese"));
    }
}