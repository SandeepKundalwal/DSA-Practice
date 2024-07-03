public class Main {
    public static void main(String[] args) {
        int red = 34;
        int blue = 43;
        System.out.println(maxHeightOfTriangle(red, blue));
    }

    public static int maxHeightOfTriangle(int red, int blue) {
        return Math.max(f(red, blue, 0), f(red, blue, 1)) - 1;
    }

    public static int f(int red, int blue, int turn){
        int height = 1;
        while(red > 0 || blue > 0){
            if(turn == 0){
                if(red < height) break;

                red -= height;
            } else {
                if(blue < height) break;

                blue -= height;
            }

            height++;
            turn ^= 1;
        }

        return height;
    }
}