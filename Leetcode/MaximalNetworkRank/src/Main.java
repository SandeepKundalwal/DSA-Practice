public class Main {
    public static void main(String[] args) {
        int n = 4;
        int roads[][] = {{0,1},{0,3},{1,2},{1,3}};
        System.out.println("Direct Connectivity: " + DirectConnectivity.maximalNetworkRank(n, roads));
        System.out.println("Indegree: " + Indegree.maximalNetworkRank(n, roads));
    }
}