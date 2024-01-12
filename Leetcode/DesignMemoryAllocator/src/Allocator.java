import java.util.Arrays;

public class Allocator {
    private int mUnit[];

    public Allocator(int n) {
        mUnit = new int[n];
    }

    public int allocate(int size, int mID) {
        for (int i = 0; i < mUnit.length; i++) {
            if (mUnit[i] == 0) {
                int j = i + 1;
                int freeSpace = 1;
                while (j < mUnit.length && mUnit[j] == 0 && freeSpace != size) {
                    j++;
                    freeSpace++;
                }

                if (freeSpace == size) {
                    Arrays.fill(mUnit, i, i + size, mID);
                    return i;
                }
                i = j - 1;
            }
        }
        return -1;
    }

    public int free(int mID) {
        int freedSpace = 0;
        for(int i = 0; i < mUnit.length; i++){
            if(mUnit[i] == mID){
                freedSpace++;
                mUnit[i] = 0;
            }
        }
        return freedSpace;
    }
}
