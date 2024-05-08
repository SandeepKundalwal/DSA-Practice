import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        String path = "/home/user/Documents/../../Pictures";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        if(path.isEmpty()){
            return "/";
        }

        String splittedPath[] = path.split("/");
        Deque<String> deque = new ArrayDeque<>();

        for(String fidr : splittedPath){
            if(!fidr.isEmpty()){
                if(fidr.equals(".")){
                    continue;
                } else if(fidr.equals("..")){
                    if(!deque.isEmpty()){
                        deque.removeLast();
                    }
                } else {
                    deque.addLast(fidr);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append("/").append(deque.removeFirst());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}