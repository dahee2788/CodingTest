package codingtest_ipmoon;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(solution(n));
    }
    static int solution(int n){
        if(n == 1 ) return 1;
        else return n*solution(n-1);
    }
}
