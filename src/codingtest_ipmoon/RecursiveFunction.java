package codingtest_ipmoon;

import java.util.Scanner;

public class RecursiveFunction {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        solution(n);
    }
    static void solution(int n){
        if(n == 0) return; // 0 찍으면 리턴
        else {
            solution(n-1); // 이 라인에서 계속 본인 함수 호출
            System.out.print(n + " "); // 리턴 되면 함수 호출한 이후 라인부터 수행. => 123~
        }
    }
}
