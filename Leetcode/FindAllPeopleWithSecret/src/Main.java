import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 11;
        int meetings[][] = {{3,1,4},{2,3,2},{3,4,4},{5,6,5},{6,7,5},{7,4,5},{7,9,6},{9,2,6}};
        int firstPerson = 1;
        System.out.println(findAllPeople(n, meetings, firstPerson));
    }

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<Integer[]>> graph = new TreeMap<>();
        for(int meeting[] : meetings){
            int ti = meeting[2];

            if(!graph.containsKey(ti)){
                graph.put(ti, new ArrayList<>());
            }

            graph.get(ti).add(new Integer[]{meeting[0], meeting[1]});
        }

        DSU dsu = new DSU(n);
        dsu.union(0, firstPerson);

        Set<Integer> knows = new HashSet<>(List.of(0, firstPerson));
        for(Map.Entry<Integer, List<Integer[]>> it : graph.entrySet()){
            for(Integer pair[] : it.getValue()){
                int u = pair[0];
                int v = pair[1];

                dsu.union(u, v);
            }

            for(Integer pair[] : it.getValue()){
                int u = pair[0];
                int v = pair[1];

                if(dsu.find(u) == 0 || dsu.find(v) == 0){
                    knows.add(u);
                    knows.add(v);
                } else {
                    dsu.breakConnection(u, v);
                }
            }
        }

        return new ArrayList<>(knows);
    }

    static class DSU{
        int parents[];

        public DSU(int n){
            this.parents = new int[n];

            for(int i = 0; i < n; i++){
                this.parents[i] = i;
            }
        }

        public int find(int e){
            if(parents[e] == e){
                return e;
            }
            return parents[e] = find(parents[e]);
        }

        public void union(int u, int v){
            int p_u = find(u);
            int p_v = find(v);

            if(parents[p_u] == 0 || parents[p_v] == 0){
                parents[p_u] = 0;
                parents[p_v] = 0;
            } else {
                parents[p_u] = p_v;
            }
        }

        public void breakConnection(int u, int v){
            parents[u] = u;
            parents[v] = v;
        }
    }
}