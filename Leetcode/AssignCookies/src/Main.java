import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int g[] = {1,2,3};
        int s[] = {1,2};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int greed = g.length - 1;
        int cookie = s.length - 1;
        int maxContent = 0;
        while(greed >= 0 && cookie >= 0){
            if(s[cookie] >= g[greed]){
                maxContent++;
                cookie--;
                greed--;
            } else {
                greed--;
            }
        }
        return maxContent;
    }
}