package codingtest_ipmoon;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i< n; i++) arr[i] = s.nextInt();

        solution(n,m,arr);
//        Arrays.sort(arr);
//        for(int i = 0; i< n; i++){
//            if(arr[i] == m){
//                System.out.println(i+1);
//                break;
//            }
//        }
    }
    static void solution(int n, int m, int[]arr){
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0, rt = n -1;
        while (lt <= rt){
            int mid = (lt + rt) / 2 ; // 평균구하는 식 중간 값을 구해서 m과 일치하는지 확인
            if(arr[mid] == m) {
                answer = mid+1;
                break;
            }
            else if(arr[mid] > m) rt = mid -1; // 중간 값 보다 m이 작다면 rt를 mid 보다 적게
            else lt = mid + 1; // 중간 값 보다 m이 크다면 lt를 mid 보다 크게
        }
        System.out.println(answer);
    }
}
