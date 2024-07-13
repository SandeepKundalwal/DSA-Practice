import java.util.*;

public class Main {
    public static void main(String[] args) {
        int positions[] = {7, 1, 3, 2, 6, 4};
        int healths[] = {8,10,5,12,15,7};
        String directions = "RLLRRL";
        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        Robot robots[] = new Robot[n];
        for(int i = 0; i < n; i++){
            robots[i] = new Robot(i, healths[i], positions[i], directions.charAt(i) == 'R' ? 1 : -1);
        }

        Arrays.sort(robots, (a, b) -> (a.position - b.position));

        Stack<Robot> stk = new Stack<>();
        for(int i = 0; i < n; i++){
            if(stk.isEmpty()){
                stk.push(robots[i]);
            } else {
                boolean pushRobot = true;
                // check if they are goin to collid
                while(!stk.isEmpty() && stk.peek().direction == 1 && robots[i].direction == -1){
                    Robot robot = stk.pop();
                    if(robot.health == robots[i].health){
                        pushRobot = false;
                        break;
                    } else if(robot.health < robots[i].health){
                        robots[i].health -= 1;
                    } else {
                        pushRobot = false;
                        robot.health -= 1;
                        stk.push(robot);
                        break;
                    }
                }

                if(pushRobot){
                    stk.push(robots[i]);
                }
            }
        }

        List<Robot> remainingRobots = new ArrayList<>();
        while(!stk.isEmpty()){
            remainingRobots.add(stk.pop());
        }

        Collections.sort(remainingRobots, (a, b) -> (a.idx - b.idx));

        List<Integer> remainingHealth = new ArrayList<>();
        for(Robot robot : remainingRobots){
            remainingHealth.add(robot.health);
        }

        return remainingHealth;
    }

    static class Robot{
        int idx;
        int health;
        int position;
        int direction;

        public Robot(int idx, int health, int position, int direction){
            this.idx = idx;
            this.health = health;
            this.position = position;
            this.direction = direction;
        }
    }
}