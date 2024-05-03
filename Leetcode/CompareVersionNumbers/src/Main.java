public class Main {
    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();

        int i = 0;
        int j = 0;
        while(i < n || j < m){
            StringBuilder v1SB = new StringBuilder();
            while(i < n && version1.charAt(i) != '.'){
                v1SB.append(version1.charAt(i));
                i++;
            }
            i++;

            StringBuilder v2SB = new StringBuilder();
            while(j < m && version2.charAt(j) != '.'){
                v2SB.append(version2.charAt(j));
                j++;
            }
            j++;

            int v1 = v1SB.length() == 0 ? 0 : Integer.parseInt(v1SB.toString());
            int v2 = v2SB.length() == 0 ? 0 : Integer.parseInt(v2SB.toString());

            if(v1 < v2){
                return -1;
            } else if(v1 > v2){
                return 1;
            }
        }
        return 0;
    }
}