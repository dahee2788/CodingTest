package codingtest_ipmoon;

import java.util.Scanner;

public class VisibleStuden {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len  = Integer.parseInt(s.nextLine());
        int bigger = 0;
        int c = 0;
        for(int i = 0; i< len; i++){
            int num = s.nextInt();
            if(bigger<num){
                c++;
                bigger = num;
            }
        }
        System.out.println(c);

    }
}
