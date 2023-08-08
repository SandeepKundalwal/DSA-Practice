public class Main {
    public static void main(String[] args) {
        int target = 0;
        int nums[] = {4,5,6,7,0,1,2};
        System.out.println("First Intuition: " + FirstIntuition.search(nums, target));
        System.out.println("Optimal: " + Optimal.search(nums, target));
    }
}