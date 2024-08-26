package codingtest_ipmoon;

import java.util.Scanner;

public class FibonacciSequence {
    static int [] arr;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        arr = new int[n+1]; // 인덱스 0이 아닌 1부터 시작 그래서 n+1
//        solution(n);
        for (int i  = 1; i<=n; i++){
            System.out.print(solution(i) + " ");
        }
    }
    static int solution(int n){
        if(arr[n] > 0) return arr[n]; // 0보다 크면 == 값이 있으면 해당 인덱스 값 바로 리턴
        if(n <= 1) return arr[n] = n;
//        else return arr[n] = solution(n-2) + solution(n-1); //  기억하자 피보나치 수열은 n-2 + n-1 // 계속 함수를 호출하는 건 스택에 프레임이 엄청 쌓임 그래서 포문보다 재귀함수 호출이 더 성능이 좋지 않음
        else return arr[n] = arr[n-2] + arr[n-1]; //  기억하자 피보나치 수열은 n-2 + n-1

    }
}
