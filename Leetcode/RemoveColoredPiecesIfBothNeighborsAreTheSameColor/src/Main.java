public class Main {
    public static void main(String[] args) {
        System.out.println(winnerOfGame("AAABBB"));
    }

    public static boolean winnerOfGame(String colors) {
        if(colors.length() < 3){
            return false;
        }

        int bob = 0;
        int alice = 0;
        for(int i = 1; i < colors.length() - 1; i++){
            char prevChar = colors.charAt(i - 1);
            char currChar = colors.charAt(i);
            char nextChar = colors.charAt(i + 1);
            if(prevChar == 'A' && currChar == 'A' && nextChar == 'A'){
                alice++;
            } else if(prevChar == 'B' && currChar == 'B' && nextChar == 'B'){
                bob++;
            }
        }

        return alice > bob;
    }
}