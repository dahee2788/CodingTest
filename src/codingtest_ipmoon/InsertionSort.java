package codingtest_ipmoon;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        for (int i =0; i<n; i++) arr[i] = s.nextInt();

        for(int i = 1; i<n;i++){
              int x = arr[i], j;
            for( j = i-1; j>=0; j--){
                if(x < arr[j]){
                    arr[j+1] = arr[j];
                }else break;
            }
            arr[j+1] = x;
        }
        for (int a : arr) System.out.print(a + " ");
    }
}
