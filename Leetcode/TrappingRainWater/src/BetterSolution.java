public class BetterSolution {
    public int trap(int[] height) {
        int trappedWater = 0;
        int prefixMax[] = findPrefixMax(height);
        int suffixMax[] = findSuffixMax(height);

        for(int i = 0; i < height.length; i++){
            int waterTrapped = Math.min(prefixMax[i], suffixMax[i]) - height[i];
            trappedWater += Math.max(0, waterTrapped);
        }
        return trappedWater;
    }

    public int[] findPrefixMax(int height[]){
        int prefixMax[] = new int[height.length];
        prefixMax[0] = height[0];
        for(int i = 1; i < height.length; i++){
            prefixMax[i] = Math.max(height[i], prefixMax[i - 1]);
        }
        return prefixMax;
    }

    public int[] findSuffixMax(int height[]){
        int n = height.length;
        int suffixMax[] = new int[n];
        suffixMax[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0 ; i--){
            suffixMax[i] = Math.max(height[i], suffixMax[i + 1]);
        }
        return suffixMax;
    }
}
