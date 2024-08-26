package codingtest_ipmoon;

import java.util.Scanner;

public class PrintLargeNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int c = 0;
        for(int i = 0; i < n; i++){
            int num  = s.nextInt();
            if(c < num){
                System.out.print(num + " ");
            }
            c = num;
        }
    }
}
