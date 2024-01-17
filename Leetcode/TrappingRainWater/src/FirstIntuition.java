public class FirstIntuition {
    public int trap(int[] height) {
        int trappedWater = 0;
        for(int i = 0; i < height.length; i++){
            int maxLeft = maxLeft(i, height);
            int maxRight = maxRight(i, height);
            if(maxLeft == 0 || maxRight == 0){
                continue;
            } else {
                int water = (Math.min(maxLeft, maxRight) - height[i]);
                trappedWater += (water < 0 ? 0 : water);
            }
        }
        return trappedWater;
    }

    public int maxLeft(int idx, int height[]){
        int maxHeight = 0;
        for(int i = 0; i < idx; i++){
            maxHeight = Math.max(maxHeight, height[i]);
        }
        return maxHeight;
    }

    public int maxRight(int idx, int height[]){
        int maxHeight = 0;
        for(int i = idx + 1; i < height.length; i++){
            maxHeight = Math.max(maxHeight, height[i]);
        }
        return maxHeight;
    }
}
