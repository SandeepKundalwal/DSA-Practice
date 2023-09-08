import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> pascalTriangle = generate(4);

        for(List<Integer> row : pascalTriangle){
            for(int element : row){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(List.of(1));

        if(numRows == 1){
            return pascalTriangle;
        }

        for(int i = 1; i < numRows; i++){
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);

            for(int j = 1; j < i; j++){
                currRow.add(pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));
            }

            currRow.add(1);
            pascalTriangle.add(currRow);
        }

        return pascalTriangle;
    }
}