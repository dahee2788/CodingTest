package codingtest_ipmoon;

import java.util.Scanner;

public class MaximumRevenue {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int [] sArr = new int[n];
        int [] arr = new int[n];

        for(int i =0; i< n; i++){
            arr[i] = s.nextInt();
        }
        // 누적합
        for(int i = 0; i<n; i++){
            if(i == 0) sArr[i] = arr[i];
            else {
                sArr[i] =  sArr[i-1] + arr[i];
            }
        }
        // 3 부터 끝까지
        //sarr[i]- sarr[i-3]
        int sum = 0;
        for(int i =k-1 ; i < n; i++){
            if(i == k-1) sum = sArr[i];
            else {
                int temp = sArr[i] - sArr[i-k];
                if(sum < temp) sum =  temp;
            }
        }
//        System.out.println(sum);
        System.out.println(solution(n,k,arr));
    }

    static int solution(int n, int k , int [] arr){
        int answer, sum = 0;
        for(int i = 0; i<k; i++) sum += arr[i];
        answer = sum;
        for(int i = k; i <n; i++){
            sum = sum + arr[i] - arr[i-k];
            answer = Math.max(answer,sum);
        }
        return  answer;
    }
}
