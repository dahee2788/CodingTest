package codingtest_ipmoon;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i<n; i++) arr[i] = s.nextInt();

        for(int i = 0; i<n-1; i++){ // 둘째자리 까지 정해졌으면 1번 숫자도 정해졌기때문에 굳이 끝까지 돌 필요 없음
            for(int j = 0; j<n-i-1; j++){ // 1회차가 돌면 끝부터 숫자가 맞춰지기때문에 이미 정해진 끝까지 돌 필요 없음.-1하기
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        for(int a : arr) System.out.print(a + " ");

    }
}
