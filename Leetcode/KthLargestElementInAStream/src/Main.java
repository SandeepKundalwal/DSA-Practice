public class Main {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{5, -1});
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(4));
    }
}