import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatings {
    static Map<String, String> foodCuisineMap;
    static Map<String, Integer> foodRatingMap;
    static Map<String, PriorityQueue<Food>> cuisineFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        foodCuisineMap = new HashMap<>();
        foodRatingMap = new HashMap<>();
        cuisineFoodMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);

            Food food = new Food(ratings[i], foods[i]);
            cuisineFoodMap.computeIfAbsent(cuisines[i], key -> new PriorityQueue<>(Comparator.comparing(Food::getRating).reversed()
                    .thenComparing(Food::getFood))).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food, newRating);
        String cuisine = foodCuisineMap.get(food);
        cuisineFoodMap.get(cuisine).add(new Food(newRating, food));
    }

    public String highestRated(String cuisine) {
        Food highestRated = cuisineFoodMap.get(cuisine).peek();

        while(foodRatingMap.get(highestRated.getFood()) != highestRated.getRating()){
            cuisineFoodMap.get(cuisine).poll();
            highestRated = cuisineFoodMap.get(cuisine).peek();
        }

        return highestRated.getFood();
    }
}
