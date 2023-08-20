import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int edges[][] = {
                {0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}
        };
        System.out.println("GenerateAllSpanningTrees: " + GenerateAllSpanningTrees.findCriticalAndPseudoCriticalEdges(n, edges));
        System.out.println("OptimalApproach: " + OptimalApproach.findCriticalAndPseudoCriticalEdges(n, edges));
    }
}