public class Main {
    public static void main(String[] args) {
        String logs[] = {"d1/", "d2/", "d3/", "../", "../", "../", "../"};
        System.out.println(minOperations(logs));
    }

    public static int minOperations(String[] logs) {
        int operations = 0;
        for(String log : logs){
            if(log.equals("./")){
                continue;
            } else if(log.equals("../")){
                if(operations > 0){
                    operations--;
                }
            } else {
                operations++;
            }
        }

        return operations;
    }
}