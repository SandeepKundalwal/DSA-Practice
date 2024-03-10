import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int apple[] = {1,3,2};
        int capacity[] = {4,3,1,5,2};
        System.out.println(minimumBoxes(apple, capacity));
    }

    public static int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);

        int totalApples = Arrays.stream(apple).sum();

        int boxes = 0;

        for(int i = capacity.length - 1; i >= 0; i--){
            if(totalApples <= 0){
                break;
            }
            totalApples -= capacity[i];
            boxes++;
        }
        return boxes;
    }
}