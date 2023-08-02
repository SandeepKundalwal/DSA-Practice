import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {
    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            return new ArrayList<>(Arrays.asList(1));
        }

        List<Integer> prevRow = new ArrayList<>(Arrays.asList(1,1));

        for(int i = 2; i <= rowIndex; i++){
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for(int j = 1; j < i; j++){
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(1);
            prevRow = currRow;
        }

        return prevRow;
    }
}
