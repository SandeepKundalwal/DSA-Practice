import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String formula = "K4(ON(SO3)2)2";
        System.out.println(countOfAtoms(formula));
    }

    public static String countOfAtoms(String formula) {
        int n = formula.length();

        Stack<String> stk = new Stack<>();
        for(int i = 0; i < n;){
            char c = formula.charAt(i);

            if(Character.isLetter(c)){
                i++;
                StringBuilder atom = new StringBuilder();
                atom.append(c);
                if(i < n){
                    char nextC = formula.charAt(i);
                    if(Character.isLetter(nextC) && Character.isLowerCase(nextC)){
                        atom.append(nextC);
                        i++;
                    }
                }
                stk.push(atom.toString());
            } else if(Character.isDigit(c)){
                i++;
                StringBuilder mCount = new StringBuilder();
                mCount.append(c);
                while(i < n && Character.isDigit(formula.charAt(i))){
                    mCount.append(formula.charAt(i));
                    i++;
                }
                stk.push(mCount.toString());
            } else if(c == '('){
                stk.push("(");
                i++;
            } else {
                i++;
                StringBuilder u = new StringBuilder();
                while(i < n && Character.isDigit(formula.charAt(i))){
                    u.append(formula.charAt(i));
                    i++;
                }

                int num = u.length() == 0 ? 0 : Integer.parseInt(u.toString());

                Stack<String> temp = new Stack<>();
                while(!stk.isEmpty() && stk.peek() != "("){
                    String pop = stk.pop();
                    if(Character.isDigit(pop.charAt(0))){
                        int count = Integer.parseInt(pop) * (num > 0 ? num : 1);
                        temp.push(String.valueOf(count));
                        temp.push(stk.pop());
                    } else {
                        temp.push(String.valueOf(num));
                        temp.push(pop);
                    }
                }
                stk.pop();

                while(!temp.isEmpty()){
                    stk.push(temp.pop());
                }
            }
        }

        Stack<String> newStk = new Stack<>();
        while(!stk.isEmpty()){
            newStk.push(stk.pop());
        }

        TreeMap<String, Integer> atomsMap = new TreeMap<>();
        while(!newStk.isEmpty()){
            String atom = newStk.pop();

            int val = 1;
            if(!newStk.isEmpty() && Character.isDigit(newStk.peek().charAt(0))){
                val = Integer.parseInt(newStk.pop());
            }
            atomsMap.put(atom, atomsMap.getOrDefault(atom, 0) + val);
        }

        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, Integer> it : atomsMap.entrySet()){
            result.append(it.getKey());
            if(it.getValue() > 1){
                result.append(it.getValue());
            }
        }

        return result.toString();
    }
}