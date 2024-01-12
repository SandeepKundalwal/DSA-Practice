public class Main {
    public static void main(String[] args) {
        Allocator allocator = new Allocator(10);
        System.out.println(allocator.allocate(1, 1));
        System.out.println(allocator.allocate(1,2));
        System.out.println(allocator.allocate(1,3));
        System.out.println(allocator.free(2));
        System.out.println(allocator.allocate(3,4));
        System.out.println(allocator.allocate(1,1));
        System.out.println(allocator.allocate(1,1));
        System.out.println(allocator.free(1));
        System.out.println(allocator.allocate(10,2));
        System.out.println(allocator.free(7));
    }
}