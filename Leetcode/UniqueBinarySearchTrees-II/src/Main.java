import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        System.out.println("First Intuition: " + FirstIntuition.generateTrees(n));
        System.out.println("Optimal Code: " + OptimalCode.generateTrees(n));
    }
}