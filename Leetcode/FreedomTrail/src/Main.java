import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String ring = "cimrihxbkmotdfudkkrovdydtyamiqdsogsaffnvdqucwfdrtrppmsjsmbekuxzltpktpzcuayjtowoyemlzggktxzkqzosenqgb";
        String key = "dnkvlggcpqslgsbmnyiukfcglsgglvbqvoosetoktrtgezvbukxqsmiefoffbsgdoomhgfmqumsmmdspqckblzcawzupwagsmwii";
        System.out.println(findRotateSteps(ring, key));
    }

    public static int findRotateSteps(String ring, String key) {
        int MEMO[][] = new int[ring.length()][key.length()];
        for(int oneD[] : MEMO){
            Arrays.fill(oneD, -1);
        }
        return f(0, 0, ring, key, MEMO);
    }

    public static int f(int idxR, int idxK, String ring, String key, int MEMO[][]){
        if(idxK >= key.length()){
            return 0;
        }

        if(MEMO[idxR][idxK] != -1){
            return MEMO[idxR][idxK];
        }

        int minTurns = Integer.MAX_VALUE;
        for(int i = 0; i < ring.length(); i++){
            if(ring.charAt(i) == key.charAt(idxK)){
                int turnsBetween = Math.abs(i - idxR);
                int turnsAround = ring.length() - turnsBetween;
                minTurns = Math.min(minTurns, 1 + Math.min(turnsBetween, turnsAround) + f(i, idxK + 1, ring, key, MEMO));
            }
        }

        return MEMO[idxR][idxK] = minTurns;
    }
}