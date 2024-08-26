package codingtest_ipmoon;

import java.util.Arrays;
import java.util.Scanner;

public class DecisionAlgorithm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n  = s.nextInt();
        int m  = s.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i<n; i++) arr[i] = s.nextInt();
        System.out.println(solution(m,arr));
    }

    static int solution(int m, int [] arr){
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt <= rt){
            int mid = (lt + rt) / 2; // 용량 capacity
            if(count(arr,mid) <= m){ // m보다 적으면 계속 answer
                answer = mid;
                rt = mid - 1; // 최소값을 찾기 위해 왼쪽으로 전진
            }
            else lt = mid+1;

        }
        return answer;
    }
    static int count(int []arr, int capacity){
        int cnt =1, sum = 0; // 앨범 1 기본
        for(int x : arr){
            if(sum+x > capacity){ // 용량 만큼 채우다가 넘치면 다음 앨범으로
                cnt++;
                sum = x;
            }else sum += x;
        }
        return cnt;
    }
}
