package codingtest_ipmoon;

import java.util.Scanner;

public class SumOfConsecutiveNaturalNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = n/2 + 1;
        int cnt = 0;

        for (int i = 1; i<= m ; i++){
           int a = i;
           int b = a+1;
            int sum = a;
            while (b < n){
                sum = sum + b;
                if(sum == n) cnt++;
                else if(sum < n) b++;
                else break;
            }

        }
        System.out.println(cnt);
//        System.out.println(solution(n));
        System.out.println(solution2(n));

    }

    static int solution(int n){
        int cnt = 0, sum = 0, lt = 0;
        int m = n/2 + 1;
        int[] arr = new int[m];
        for(int i = 0; i< m; i++) arr[i] = i+1;
        for(int rt = 0; rt < m; rt++){
            sum += arr[rt];
            if(sum == n) cnt++;
            while (sum >= n){
                sum -= arr[lt++];
                if(sum == n) cnt++;
            }
        }

        return cnt;
    }
    static int solution2(int n){
        int answer = 0, cnt = 1;
        n--;
        while(n > 0){
            cnt++;
            n = n-cnt;
            if(n%cnt == 0) answer++;
        }
        return answer;
    }
}
