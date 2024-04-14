public class Main {
    public static void main(String[] args) {
        String s = "1?:?4";
        System.out.println(findLatestTime(s));
    }

    public static String findLatestTime(String s) {
        String split[] = s.split(":");

        String hour = split[0];
        String min = split[1];

        StringBuilder sb = new StringBuilder();

        if(hour.charAt(0) == '?'){
            if(hour.charAt(1) == '?'){
                sb.append("11");
            } else {
                if(hour.charAt(1) - '0' > 1){
                    sb.append("0").append(hour.charAt(1));
                } else {
                    sb.append("1").append(hour.charAt(1));
                }
            }
        } else if(hour.charAt(1) == '?') {
            if(hour.charAt(0) == '0'){
                sb.append("0").append("9");
            } else {
                sb.append("1").append("1");
            }
        } else {
            sb.append(hour);
        }

        sb.append(":");

        if(min.charAt(0) == '?'){
            if(min.charAt(1) == '?'){
                sb.append("59");
            } else {
                sb.append("5").append(min.charAt(1));
            }
        } else if(min.charAt(1) == '?') {
            sb.append(min.charAt(0)).append("9");
        } else {
            sb.append(min);
        }


        return sb.toString();
    }
}