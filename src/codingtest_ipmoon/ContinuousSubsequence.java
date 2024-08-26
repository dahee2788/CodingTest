package codingtest_ipmoon;

import java.util.Scanner;

public class ContinuousSubsequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int [] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = s.nextInt();
        }

        int cnt = 0;
        // 슬라이딩 범위를 2~ n까지
//        for(int i= 2; i <n; i++){
//            int k = i;
//            int sum = 0;
//            for(int j =0; j<k; j++) sum += arr[j];
//            if(sum == m) cnt++;
//            for(int d = k; d < n; d++){
//                sum = sum + arr[d] - arr[d-k];
//                if(sum == m) cnt++;
//            }
//        }
//        System.out.println(cnt);
        System.out.println(solution2(n,m,arr));
    }

    static int solution(int n, int m, int [] arr){
        int cnt = 0, sum = 0, lt = 0;
        for(int rt = 0; rt< n; rt++){
            sum += arr[rt];
            if(sum == m) cnt++;
            while (sum >= m){
                sum -= arr[lt++];
                if( sum == m) cnt++;
            }
        }
        return cnt;
    }
    static int solution2(int n, int m, int [] arr){
        int cnt = 0;
        int lt = 0, rt = 0;
        int sum = arr[lt];
        while (lt < n-1 && rt < n-1){
            if(sum < m) sum += arr[++rt];
            if(sum > m ) sum = sum-arr[lt++];
            if(sum == m){
                cnt++;
                sum = sum-arr[lt++];
            };

        }
        return cnt;
    }
}
