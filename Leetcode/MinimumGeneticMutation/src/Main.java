import java.util.*;

public class Main {
    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String bank[] = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(minMutation(startGene, endGene, bank));
    }

    public static int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)) return 0;

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if(!bankSet.contains(endGene)) return -1;

        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                List<String> allMutations = findAllMutations(queue.remove(), visited, bankSet);

                for(String mutation : allMutations){
                    if(endGene.equals(mutation)){
                        return level + 1;
                    }

                    queue.offer(mutation);
                }
            }
            level++;
        }

        return -1;
    }

    public static List<String> findAllMutations(String mutation, Set<String> visited, Set<String> bankSet){
        List<String> allMutations = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            char mutationChars[] = mutation.toCharArray();
            char c = mutationChars[i];

            if(c != 'A'){
                mutationChars[i] = 'A';
                String newMutation = String.valueOf(mutationChars);
                if(!visited.contains(newMutation) && bankSet.contains(newMutation)){
                    visited.add(newMutation);
                    allMutations.add(newMutation);
                }
            }

            if(c != 'C'){
                mutationChars[i] = 'C';
                String newMutation = String.valueOf(mutationChars);
                if(!visited.contains(newMutation) && bankSet.contains(newMutation)){
                    visited.add(newMutation);
                    allMutations.add(newMutation);
                }
            }

            if(c != 'G'){
                mutationChars[i] = 'G';
                String newMutation = String.valueOf(mutationChars);
                if(!visited.contains(newMutation) && bankSet.contains(newMutation)){
                    visited.add(newMutation);
                    allMutations.add(newMutation);
                }
            }

            if(c != 'T'){
                mutationChars[i] = 'T';
                String newMutation = String.valueOf(mutationChars);
                if(!visited.contains(newMutation) && bankSet.contains(newMutation)){
                    visited.add(newMutation);
                    allMutations.add(newMutation);
                }
            }
        }

        return allMutations;
    }
}