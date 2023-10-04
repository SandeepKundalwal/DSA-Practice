import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(2,5);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }

    static class MyHashMap {
        int hashMap[];
        public MyHashMap() {
            hashMap = new int[(int)1e6 + 1];
            Arrays.fill(hashMap, -1);
        }

        public void put(int key, int value) {
            hashMap[key] = value;
        }

        public int get(int key) {
            return hashMap[key];
        }

        public void remove(int key) {
            hashMap[key] = -1;
        }
    }
}