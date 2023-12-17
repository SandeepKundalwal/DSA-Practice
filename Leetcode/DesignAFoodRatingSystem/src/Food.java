public class Food {
    private int rating;
    private String food;

    public Food(int rating, String food) {
        this.rating = rating;
        this.food = food;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
