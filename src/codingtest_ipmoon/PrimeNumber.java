package codingtest_ipmoon;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int [] arr = new int[num+1];
        int c = 0;

        for(int i = 2; i<=num; i++){
            if(arr[i] == 0) c++;
            int q = num/i;
            for(int j = 1; j <= q; j++){
                arr[j*i] = 1;
            }
        }
        System.out.println(c);
    }
}
