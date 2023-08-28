public class Main {
    public static void main(String[] args) {
        System.out.println("Using Two Queue:");
        TwoQueue twoQueue = new TwoQueue();
        twoQueue.push(1);
        twoQueue.push(2);
        twoQueue.push(3);
        System.out.println(twoQueue.top());
        System.out.println(twoQueue.pop());
        twoQueue.push(5);
        System.out.println(twoQueue.pop());

        System.out.println("Using One Queue:");
        OneQueue oneQueue = new OneQueue();
        oneQueue.push(1);
        oneQueue.push(2);
        oneQueue.push(3);
        System.out.println(oneQueue.top());
        System.out.println(oneQueue.pop());
        oneQueue.push(5);
        System.out.println(oneQueue.pop());
    }
}