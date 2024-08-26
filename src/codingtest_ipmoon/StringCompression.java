package codingtest_ipmoon;
import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[]sArray = str.split("");
        StringBuilder sb = new StringBuilder(sArray[0]);
        int cnt = 1;
        for(int i = 1; i<sArray.length; i++){
            if(sArray[i-1].equals(sArray[i])) cnt++;
            else {
                if(cnt > 1) sb.append(cnt);
                sb.append(sArray[i]);
                cnt = 1;
            }
        }
        if(cnt > 1) sb.append(cnt);
        System.out.println(sb.toString());
    }

}
