public class Main {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(9, 15));
    }

    public static int rangeBitwiseAnd(int left, int right) {
        int answer = 0;
        for(int bit = 31; bit >= 0; bit--){
            if((left & (1 << bit)) != (right &(1 << bit))){
                break;
            } else {
                answer |= (left & (1 << bit));
            }
        }
        return answer;
    }
}