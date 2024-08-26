package codingtest_ipmoon;

import java.util.Scanner;

public class FibonacciSquence {
    static int[] fArray;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        fArray = new int[n+1];
//        for(int i = 1; i<=n; i++){
////            System.out.print(solution(i) + " ");
//            System.out.print(solution_memo(i) + " ");
//        }
        solution_teacher(n);
    }
    static int solution(int f){
        if(f <= 1) return f;
        return solution(f-1) + solution(f -2);
    }
    static int solution_memo(int f){
        if(f <= 1) return fArray[f] = f;
        else if(fArray[f] > 0) return fArray[f];
        else {
            return fArray[f] = solution_memo(f -1) + solution_memo(f -2);
        }
    }
    static void solution_teacher(int f){
        int a =0 , b=1, c;
        for(int i = 1; i < f; i++){
            if(i == 1) System.out.print(1 + " ");
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
