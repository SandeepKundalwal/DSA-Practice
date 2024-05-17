import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String emails[] = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for(String email : emails){
            StringBuilder realEmail = new StringBuilder();

            String parts[] = email.split("@");

            for(char c : parts[0].toCharArray()){
                if(c == '+'){
                    break;
                } else if(Character.isLetter(c)){
                    realEmail.append(c);
                }
            }

            realEmail.append("@").append(parts[1]);
            uniqueEmails.add(realEmail.toString());
        }

        return uniqueEmails.size();
    }
}