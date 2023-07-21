import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int asteroids[] = new int[]{5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    /**
     + -> right direction
     - -> left direction
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroidState = new Stack<>();

        for(int i = 0; i < asteroids.length; i++){
            int asteroid = asteroids[i];
            if(asteroidState.isEmpty()){
                asteroidState.push(asteroid);
            } else {
                if(asteroid < 0){
                    boolean currentAsteroidDestroyed = false;
                    while(!asteroidState.isEmpty()){
                        int topAsteroid = asteroidState.peek();
                        /**
                         checking if the top of the stack and the current asteroid are both moving in the left direction.
                         if yes, then they will never collide.
                         if no, then they will collide
                         */
                        if(topAsteroid < 0){
                            asteroidState.push(asteroid);
                            break;
                        } else {
                            int collision = topAsteroid - Math.abs(asteroid);
                            /**
                             1. asteroid is bigger than topAsteroid, pop from stack
                             2. current asteroid == topAsteroid, both gone
                             3. asteroid < topAsteroid, asteroid destroyed. No change to stack
                             */
                            if(collision < 0){
                                asteroidState.pop();
                            } else if(collision == 0){
                                asteroidState.pop();
                                currentAsteroidDestroyed = true;
                                break;
                            } else {
                                currentAsteroidDestroyed = true;
                                break;
                            }
                        }
                    }

                    /**
                     if the current asteroid is larger than all the asteroid that were present in the stack and have destroyed
                     all the previous asteroid then we have to save it in the stack
                     */
                    if(asteroidState.isEmpty() && !currentAsteroidDestroyed){
                        asteroidState.push(asteroid);
                    }
                } else {
                    asteroidState.push(asteroid);
                }
            }
        }

        int idx = asteroidState.size() - 1;
        int finalAsteroidState[] = new int[asteroidState.size()];
        while(!asteroidState.isEmpty()){
            finalAsteroidState[idx--] = asteroidState.pop();
        }
        return finalAsteroidState;
    }
}