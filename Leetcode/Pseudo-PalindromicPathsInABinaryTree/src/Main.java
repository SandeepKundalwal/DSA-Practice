public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[]{2,3,1,3,1,null,1});
        System.out.println(pseudoPalindromicPaths(root));
    }

    public static int pseudoPalindromicPaths (TreeNode root) {
        int cnt[] = {0};
        f(root, new int[10], cnt);
        return cnt[0];
    }

    public static void f(TreeNode root , int freq[], int cnt[]){
        if(root == null){
            return;
        }

        freq[root.val]++;
        if(root.left == null && root.right == null){
            if(checkIfPalindrome(freq)){
                cnt[0]++;
            }
        }

        f(root.left, freq, cnt);
        f(root.right, freq, cnt);
        freq[root.val]--;
    }

    public static boolean checkIfPalindrome(int freq[]){
        int oddCount = 0;
        for(int i = 0; i < 10; i++){
            if(freq[i] % 2 != 0){
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}