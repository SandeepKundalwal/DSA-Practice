public class Main {
    public static void main(String[] args) {
        System.out.println("Amortized Linear Time: ");
        AmortizedLinearTime amortizedLinearTime = new AmortizedLinearTime();
        amortizedLinearTime.push(1);
        amortizedLinearTime.push(2);
        System.out.println(amortizedLinearTime.peek());
        System.out.println(amortizedLinearTime.pop());
        System.out.println(amortizedLinearTime.empty());

        System.out.println("Amortized Constant Time: ");
        AmortizedConstantTime amortizedConstantTime = new AmortizedConstantTime();
        amortizedConstantTime.push(1);
        amortizedConstantTime.push(2);
        System.out.println(amortizedConstantTime.peek());
        System.out.println(amortizedConstantTime.pop());
        System.out.println(amortizedConstantTime.empty());
    }
}