import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    final static Map<String, String> hashMap = generateMap();
    public static void main(String[] args) {
        int num = 1000010;
        System.out.println(numberToWords(num));
    }

    public static String numberToWords(int num) {
        if(num == 0) return "Zero";

        String numS = String.valueOf(num);

        List<String> triplets = new ArrayList<>();
        int i = numS.length() - 1;
        while(i >= 0){
            StringBuilder triplet = new StringBuilder();
            int count = 0;
            while(i >= 0 && count < 3){
                triplet.append(numS.charAt(i--));
                count++;
            }
            triplets.add(triplet.reverse().toString());
        }

        StringBuilder result = new StringBuilder();
        for(int position = triplets.size() - 1; position >= 0; position--){
            int tripletInt = Integer.parseInt(triplets.get(position));

            if(tripletInt == 0){
                continue;
            }

            String inWords = f(tripletInt).trim();
            if(position == 0){
                result.append(inWords);
            } else if(position == 1){
                result.append(inWords).append(" Thousand ");
            } else if(position == 2){
                result.append(inWords).append(" Million ");
            } else {
                result.append(inWords).append(" Billion ");
            }
        }

        return result.toString().trim();
    }

    public static String f(int tripletValue){
        String s = String.valueOf(tripletValue);

        StringBuilder sb = new StringBuilder();
        if(s.length() == 1){
            return hashMap.get(s);
        } else if(s.length() == 2){
            if(hashMap.containsKey(s)){
                sb.append(hashMap.get(s));
            } else {
                sb.append(handleLastTwoDigits(s));
            }
        } else {
            sb.append(hashMap.get(String.valueOf(s.charAt(0)))).append(" Hundred ");

            String lastTwo = s.substring(1);

            if(hashMap.containsKey(lastTwo)){
                sb.append(hashMap.get(lastTwo));
            } else {
                sb.append(handleLastTwoDigits(lastTwo));
            }
        }

        return sb.toString();
    }

    public static String handleLastTwoDigits(String lastTwo){
        String unit = lastTwo.substring(1);
        String tens = lastTwo.substring(0, 1) + "0";

        return hashMap.get(tens) + " " + hashMap.get(unit);
    }


    public static Map<String, String> generateMap(){
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("0", "");
        hashMap.put("1", "One");
        hashMap.put("2", "Two");
        hashMap.put("3", "Three");
        hashMap.put("4", "Four");
        hashMap.put("5", "Five");
        hashMap.put("6", "Six");
        hashMap.put("7", "Seven");
        hashMap.put("8", "Eight");
        hashMap.put("9", "Nine");
        hashMap.put("00",  "");
        hashMap.put("01", "One");
        hashMap.put("02", "Two");
        hashMap.put("03", "Three");
        hashMap.put("04", "Four");
        hashMap.put("05", "Five");
        hashMap.put("06", "Six");
        hashMap.put("07", "Seven");
        hashMap.put("08", "Eight");
        hashMap.put("09", "Nine");
        hashMap.put("10", "Ten");
        hashMap.put("11", "Eleven");
        hashMap.put("12", "Twelve");
        hashMap.put("13", "Thirteen");
        hashMap.put("14", "Fourteen");
        hashMap.put("15", "Fifteen");
        hashMap.put("16", "Sixteen");
        hashMap.put("17", "Seventeen");
        hashMap.put("18", "Eighteen");
        hashMap.put("19", "Nineteen");
        hashMap.put("20", "Twenty");
        hashMap.put("30", "Thirty");
        hashMap.put("40", "Forty");
        hashMap.put("50", "Fifty");
        hashMap.put("60", "Sixty");
        hashMap.put("70", "Seventy");
        hashMap.put("80", "Eighty");
        hashMap.put("90", "Ninety");

        return hashMap;
    }
}