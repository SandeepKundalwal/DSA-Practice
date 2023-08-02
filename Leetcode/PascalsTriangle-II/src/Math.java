import java.util.ArrayList;
import java.util.List;

public class Math {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> rowThIndex = new ArrayList<>();
        rowThIndex.add(1);

        if(rowIndex == 0){
            return rowThIndex;
        }

        long ans = 1;
        for(int col = 1; col <= rowIndex; col++){
            ans = ans * ((rowIndex + 1) - col);
            ans = ans / col;
            rowThIndex.add((int)ans);
        }

        return rowThIndex;
    }
}
