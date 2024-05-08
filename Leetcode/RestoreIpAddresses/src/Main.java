import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<>();
        int snap[] = new int[4];
        f(0, 0, 0, s, snap, ips);
        return ips;
    }

    public static void f(int idx, int snapIdx, int division, String s, int snap[], List<String> ips){
        if(division == 4){
            if(idx >= s.length()){
                ips.add(snap[0] + "." + snap[1] + "." + snap[2] + "." + snap[3]);
            }
            return;
        }

        for(int i = idx; i < idx + 3 && i < s.length(); i++){
            String currSnap = s.substring(idx, i + 1);

            if(Integer.parseInt(currSnap) > 255 || (currSnap.length() > 1 && currSnap.charAt(0) == '0')){
                return;
            }

            snap[snapIdx] = Integer.parseInt(currSnap);
            f(i + 1, snapIdx + 1, division + 1, s, snap, ips);
            snap[snapIdx] = -1;
        }
    }
}