package codingtest_ipmoon;

import java.util.Scanner;

public class BinaryOutput {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        solution(n);
    }

    static void solution(int n ){
        if(n == 0) return;
        else {
            int m = n / 2;
            int v = n % 2;
            solution(m);
            System.out.print(v + " ");
        };
    }
}
