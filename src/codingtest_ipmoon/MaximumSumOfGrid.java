package codingtest_ipmoon;


import java.util.Scanner;

public class MaximumSumOfGrid {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int xSum = 0;
        int ySum = 0;
        int ldSum = 0;
        int rdSum = 0;
        int[][]arr = new int[size][size];
        for (int i = 0; i< size; i++){
            for (int j = 0; j < size; j++){
                arr[i][j] = s.nextInt();
            }
        }
      // 가로
        for (int i = 0; i< size; i++){
            int sum = 0;
            for (int j = 0; j < size; j++){
                sum += arr[i][j];
            }
            if(sum > xSum) xSum = sum;
        }
      // 세로
        for (int i = 0; i< size; i++){
            int sum = 0;
            for (int j = 0; j < size; j++){
                sum += arr[j][i];
            }
            if(sum > ySum) ySum = sum;
        }
      // l대각선
        for (int i = 0; i< size; i++){
            for (int j = 0; j < size; j++){
                if(i == j) ldSum += arr[i][j];
            }
        }
        // r대각선
        for (int i = 0; i< size; i++){
            for (int j = 4; j>=0; j--){
                if(i+j == 4) rdSum += arr[i][j];
            }
        }
        int mx = ((xSum > ySum ? xSum : ySum) > ldSum ? (xSum > ySum ? xSum : ySum) : ldSum) > rdSum ? ((xSum > ySum ? xSum : ySum) > ldSum ? (xSum > ySum ? xSum : ySum) : ldSum) : rdSum;
//        System.out.println(mx);
        System.out.println(solution(size,arr));
    }
    static int solution(int n, int [][] arr){
        int answer = Integer.MIN_VALUE;
        int sum1,sum2;
        for(int i = 0 ; i < n; i++){
            sum1 = sum2 = 0;
            for(int j = 0; j < n; j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer,sum1);
            answer = Math.max(answer,sum2);
        }
        sum1 = sum2 = 0;
        for(int i = 0; i<n; i++){
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        answer = Math.max(answer,sum1);
        answer = Math.max(answer,sum2);
        return answer;
    }

}


