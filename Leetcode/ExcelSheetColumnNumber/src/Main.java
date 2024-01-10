public class Main {
    public static void main(String[] args) {
        String columnTitle = "AB";
        System.out.println(titleToNumber((columnTitle)));
    }

    public static int titleToNumber(String columnTitle) {
        int columnNumber = 0;
        int n = columnTitle.length();
        for(int i = 0; i < n; i++){
            char ch = columnTitle.charAt(i);
            int position = n - i - 1;
            columnNumber += (int) ((ch - 'A' + 1) * (position == 0 ? 1 : Math.pow(26, position)));
        }
        return columnNumber;
    }
}