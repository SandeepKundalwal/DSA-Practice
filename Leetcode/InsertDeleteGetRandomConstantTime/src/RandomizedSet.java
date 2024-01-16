import java.util.Random;
import java.util.Map;
import java.util.HashMap;

class RandomizedSet {
    int arr[];
    int size;
    Random random;
    Map<Integer, Integer> hashMap;
    public RandomizedSet() {
        size = 0;
        arr = new int[1000];
        random = new Random();
        hashMap = new HashMap<>();
    }

    public void arrayDoubling(){
        int nArr[] = new int[arr.length << 1];
        for(int i = 0; i < size; i++){
            nArr[i] = arr[i];
        }
        arr = nArr;
    }

    public boolean insert(int val) {
        if(!hashMap.containsKey(val)){
            if(arr.length == size){
                arrayDoubling();
            }
            arr[size] = val;
            hashMap.put(val, size);
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(hashMap.containsKey(val)){
            int valIdx = hashMap.get(val);
            int largestIdxElement = arr[size - 1];
            arr[valIdx] = largestIdxElement;
            hashMap.put(largestIdxElement, valIdx);
            hashMap.remove(val);
            size--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        if(size == 0){
            return -1;
        }
        int randomIdx = random.nextInt(size);
        return arr[randomIdx];
    }
}
