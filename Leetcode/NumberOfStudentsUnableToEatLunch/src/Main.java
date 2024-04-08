public class Main {
    public static void main(String[] args) {
        int students[] = {1,1,0,0};
        int sandwiches[] = {0,1,0,1};
        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int cSand = 0;
        int sSand = 0;

        for(int sandwich : students){
            if(sandwich == 0) cSand++;
            else sSand++;
        }

        for(int i = 0; i < sandwiches.length; i++){
            if(sandwiches[i] == 0 && cSand > 0){
                cSand--;
            } else if(sandwiches[i] == 1 && sSand > 0)  {
                sSand--;
            } else {
                break;
            }
        }

        return cSand + sSand;
    }
}